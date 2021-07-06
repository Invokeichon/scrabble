package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
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
        tstring = TypeFactory.createString(str);

        b = rng.nextBoolean();
        tbool = TypeFactory.createBool(b);

        dbl = rng.nextDouble();
        tfloat = TypeFactory.createFloat(dbl);

        integer = rng.nextInt();
        tint = TypeFactory.createInt(integer);

        char[] bins = {'0', '1'};
        int binSize;
        do { binSize= rng.nextInt(32); } while (binSize == 0 || binSize == 1);
        bin = RandomStringUtils.random(binSize, 0, 0,
                false, true, bins, rng);
        tbinary = TypeFactory.createBinary(bin);

    }

    @RepeatedTest(20)
    void add() {
        // TString adding all other types
        assertEquals(TypeFactory.createString(str + b), tstring.add(tbool));
        assertEquals(TypeFactory.createString(str + dbl), tstring.add(tfloat));
        assertEquals(TypeFactory.createString(str + integer), tstring.add(tint));
        assertEquals(TypeFactory.createString(str + bin), tstring.add(tbinary));

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
        assertEquals(TypeFactory.createFloat(integer + dbl), tint.add(tfloat));
        assertEquals(TypeFactory.createInt(integer + tbinary.toInt()), tint.add(tbinary));

        // TBinary adding other numbers (conversion will be used through TInt)
        TInt tr = TypeFactory.createInt(tbinary.toInt() + integer);
        assertEquals(TypeFactory.createBinary(tr.toBinary()), tbinary.add(tint));

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
        assertEquals(TypeFactory.createFloat(integer - dbl), tint.sub(tfloat));
        assertEquals(TypeFactory.createInt(integer - tbinary.toInt()), tint.sub(tbinary));

        // TBinary subtracting other numbers (conversion will be used through TInt)
        TInt tr = TypeFactory.createInt(tbinary.toInt() - integer);
        assertEquals(TypeFactory.createBinary(tr.toBinary()), tbinary.sub(tint));
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
        assertEquals(TypeFactory.createFloat(integer * dbl), tint.mult(tfloat));
        assertEquals(TypeFactory.createInt(integer * tbinary.toInt()), tint.mult(tbinary));

        // TBinary multiplying other numbers (conversion will be used through TInt)
        TInt tr = TypeFactory.createInt(tbinary.toInt() * integer);
        assertEquals(TypeFactory.createBinary(tr.toBinary()), tbinary.mult(tint));
    }

    @RepeatedTest(20)
    void div() {
        if (integer == 0) {
            integer = 1;
            tint = TypeFactory.createInt(integer);
        }
        if (dbl == 0) {
            dbl = 1;
            tfloat = TypeFactory.createFloat(dbl);
        }
        if (tbinary.toInt() == 0) {
            bin = "00000000000000000000000000000001";
            tbinary = TypeFactory.createBinary(bin);
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
        assertEquals(TypeFactory.createFloat(integer / dbl), tint.div(tfloat));
        assertEquals(TypeFactory.createInt(integer / tbinary.toInt()), tint.div(tbinary));

        // TBinary dividing other numbers (conversion will be used through TInt)
        TInt tr = TypeFactory.createInt(tbinary.toInt() / integer);
        assertEquals(TypeFactory.createBinary(tr.toBinary()), tbinary.div(tint));
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
        assertEquals(TypeFactory.createBinary(result), tbool.or(tbinary));
        assertEquals(TypeFactory.createBinary(result), tbinary.or(tbool));

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
        assertEquals(TypeFactory.createBinary(result), tbool.and(tbinary));
        assertEquals(TypeFactory.createBinary(result), tbinary.and(tbool));
    }
}