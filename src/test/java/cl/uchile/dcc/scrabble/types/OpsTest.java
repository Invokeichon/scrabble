package cl.uchile.dcc.scrabble.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OpsTest {
    private TString tstring;
    private String str;
    private TBool tbool;
    private boolean b;
    private TFloat tfloat;
    private double dbl;
    private TInt tint;
    private int integer;
    private TBinary tbinary;
    private String bin;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        tstring = new TString(str);

        b = rng.nextBoolean();
        tbool = new TBool(b);

        dbl = rng.nextDouble();
        tfloat = new TFloat(dbl);

        integer = rng.nextInt();
        tint = new TInt(integer);

        char[] bins = {'0', '1'};
        int binSize;
        do { binSize= rng.nextInt(32); } while (binSize == 0 || binSize == 1);
        bin = RandomStringUtils.random(binSize, 0, 0,
                false, true, bins, rng);
        tbinary = new TBinary(bin);

    }

    @RepeatedTest(20)
    void add() {
        // TString adding all other types
        assertEquals(new TString(str + b), tstring.add(tbool));
        assertEquals(new TString(str + dbl), tstring.add(tfloat));
        assertEquals(new TString(str + integer), tstring.add(tint));
        assertEquals(new TString(str + bin), tstring.add(tbinary));

        /*
        TFloat adding other numbers.
        Due to rounding errors in float operations, asserts must be done with a delta.
        To do so, asserts will be done directly with the value stored in the objects.
        */
        assertEquals(dbl + integer,
                Double.parseDouble(tfloat.add(tint).toString()), 1.0E9);
        assertEquals(dbl + tbinary.toInt(),
                Double.parseDouble(tfloat.add(tbinary).toString()), 1.0E9);

        // TInt adding other numbers (TInt.add(TFloat) returns TFloat)
        assertEquals(new TFloat(integer + dbl), tint.add(tfloat));
        assertEquals(new TInt(integer + tbinary.toInt()), tint.add(tbinary));

        // TBinary adding other numbers (conversion will be used through TInt)
        TInt tr = new TInt(tbinary.toInt() + integer);
        assertEquals(new TBinary(tr.toBinary()), tbinary.add(tint));

    }

    @RepeatedTest(20)
    void sub() {
        /*
        TFloat subtracting other numbers.
        Due to rounding errors in float operations, asserts must be done with a delta.
        To do so, asserts will be done directly with the value stored in the objects.
        */
        assertEquals(dbl - integer,
                Double.parseDouble(tfloat.sub(tint).toString()), 1.0E9);
        assertEquals(dbl - tbinary.toInt(),
                Double.parseDouble(tfloat.sub(tbinary).toString()), 1.0E9);

        // TInt subtracting other numbers (TInt.sub(TFloat) returns TFloat)
        assertEquals(new TFloat(integer - dbl), tint.sub(tfloat));
        assertEquals(new TInt(integer - tbinary.toInt()), tint.sub(tbinary));

        // TBinary subtracting other numbers (conversion will be used through TInt)
        TInt tr = new TInt(tbinary.toInt() - integer);
        assertEquals(new TBinary(tr.toBinary()), tbinary.sub(tint));
    }

    @RepeatedTest(20)
    void mult() {
        /*
        TFloat multiplying other numbers.
        Due to rounding errors in float operations, asserts must be done with a delta.
        To do so, asserts will be done directly with the value stored in the objects.
        */
        assertEquals(dbl * integer,
                Double.parseDouble(tfloat.mult(tint).toString()), 1.0E9);
        assertEquals(dbl * tbinary.toInt(),
                Double.parseDouble(tfloat.mult(tbinary).toString()), 1.0E9);

        // TInt multiplying other numbers (TInt.mult(TFloat) returns TFloat)
        assertEquals(new TFloat(integer * dbl), tint.mult(tfloat));
        assertEquals(new TInt(integer * tbinary.toInt()), tint.mult(tbinary));

        // TBinary multiplying other numbers (conversion will be used through TInt)
        TInt tr = new TInt(tbinary.toInt() * integer);
        assertEquals(new TBinary(tr.toBinary()), tbinary.mult(tint));
    }

    @RepeatedTest(20)
    void div() {
        if (integer == 0) {
            integer = 1;
            tint = new TInt(integer);
        }
        if (dbl == 0) {
            dbl = 1;
            tfloat = new TFloat(dbl);
        }
        if (tbinary.toInt() == 0) {
            bin = "00000000000000000000000000000001";
            tbinary = new TBinary(bin);
        }
        /*
        TFloat dividing other numbers.
        Due to rounding errors in float operations, asserts must be done with a delta.
        To do so, asserts will be done directly with the value stored in the objects.
        */
        assertEquals(dbl / integer,
                Double.parseDouble(tfloat.div(tint).toString()), 1.0E9);
        assertEquals(dbl / tbinary.toInt(),
                Double.parseDouble(tfloat.div(tbinary).toString()), 1.0E9);

        // TInt dividing other numbers (TInt.div(TFloat) returns TFloat)
        assertEquals(new TFloat(integer / dbl), tint.div(tfloat));
        assertEquals(new TInt(integer / tbinary.toInt()), tint.div(tbinary));

        // TBinary dividing other numbers (conversion will be used through TInt)
        TInt tr = new TInt(tbinary.toInt() / integer);
        assertEquals(new TBinary(tr.toBinary()), tbinary.div(tint));
    }

    @RepeatedTest(20)
    void or(){
        char p = tbool.boolToBin(b);
        String result;
        if (p == '1') {
            char[] resArr = new char[bin.length()];
            Arrays.fill(resArr, p);
            result = String.valueOf(resArr);
        }
        else { // p == '0'
            result = bin;
        }
        assertEquals(new TBinary(result), tbool.or(tbinary));
        assertEquals(new TBinary(result), tbinary.or(tbool));

    }

    @RepeatedTest(20)
    void and() {
        char p = tbool.boolToBin(b);
        String result;
        if (p == '1') {
            result = bin;
        }
        else { // p == '0'
            char[] resArr = new char[bin.length()];
            Arrays.fill(resArr, p);
            result = String.valueOf(resArr);
        }
        assertEquals(new TBinary(result), tbool.and(tbinary));
        assertEquals(new TBinary(result), tbinary.and(tbool));
    }
}