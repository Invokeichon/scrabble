package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TBinaryTest {
    private String bin;
    private TBinary tbinary;
    private int seed;
    private Random rng;
    private char[] bins = {'0', '1'};

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int binSize;
        do {binSize= rng.nextInt(32);} while (binSize == 0 || binSize == 1);
        bin = RandomStringUtils.random(binSize, 0, 0,
                false, true, bins, rng);
        tbinary = TypeFactory.createBinary(bin);
    }

    @RepeatedTest(20)
    void constructorTest() {
        var expectedTBinary = TypeFactory.createBinary (bin);
        assertEquals(expectedTBinary, tbinary);
        assertEquals(expectedTBinary.hashCode(), tbinary.hashCode(), "Hash Codes don't match.");
        int diffSize;
        String differentBin;
        do {
            diffSize = rng.nextInt(32);
            differentBin = RandomStringUtils.random(diffSize, 0, 0,
                    false, true, bins, rng);
        } while (differentBin.equals(bin) || diffSize == 0 || diffSize == 1);
        TBinary differentTBinary = TypeFactory.createBinary(differentBin);
        assertNotEquals(differentTBinary, tbinary);
        assertNotEquals(differentBin, tbinary);
    }

    @RepeatedTest(20)
    void testToString() {
        int binSize = rng.nextInt(32);
        String differentString;
        do {differentString = RandomStringUtils.random(binSize,0,0,false,
                true, null, rng);
        } while (differentString.equals(bin));
        assertEquals(bin, tbinary.toString());
        assertNotEquals(differentString, tbinary.toString());
    }

    @RepeatedTest(20)
    void testToTString() {
        int binSize = rng.nextInt(32);
        String differentString;
        do {differentString = RandomStringUtils.random(binSize,0,Character.MAX_CODE_POINT,false,
                true, null, rng);
        } while (differentString.equals(bin));
        assertEquals(TypeFactory.createString(bin), tbinary.toTString());
        assertNotEquals(TypeFactory.createString(differentString), tbinary.toTString());
    }

    @RepeatedTest(20)
    void testToTFloat() {
        double tr = tbinary.toInt();
        double diff;
        do {diff = rng.nextDouble();} while (diff == tr);
        assertEquals(TypeFactory.createFloat(tr), tbinary.toTFloat());
        assertNotEquals(TypeFactory.createFloat(diff), tbinary.toTFloat());

    }

    @RepeatedTest(20)
    void testToTInt() {
        int tr = tbinary.toInt();
        int diff;
        do {diff = rng.nextInt();} while (diff == tr);
        assertEquals(TypeFactory.createInt(tr), tbinary.toTInt());
        assertNotEquals(TypeFactory.createInt(diff), tbinary.toTInt());
    }

    @RepeatedTest(20)
    void testToTBinary() {
        int binSize = rng.nextInt(32);
        String differentString;
        do {differentString = RandomStringUtils.random(binSize,0,0,false,
                true, bins, rng);
        } while (differentString.equals(bin));
        assertEquals(TypeFactory.createBinary(bin), tbinary.toTBinary());
        assertNotEquals(TypeFactory.createBinary(differentString), tbinary.toTBinary());
    }

    @RepeatedTest(20)
    void testNegate() {
        assertNotEquals(tbinary, tbinary.negate());
        assertEquals(tbinary, tbinary.negate().negate());
    }

    @RepeatedTest(20)
    void operationsTest() {
        int binSize;
        do {binSize = rng.nextInt(32);} while (binSize == 0 || binSize == 1);
        String rightOp;
        do {rightOp = RandomStringUtils.random(binSize,0,0,false,
                true, bins, rng);
        } while (rightOp.equals(bin));
        TBinary rightTBinary = TypeFactory.createBinary(rightOp);
        TInt addT = TypeFactory.createInt(tbinary.toInt() + rightTBinary.toInt());
        assertEquals(TypeFactory.createBinary(addT.toBinary()), tbinary.add(rightTBinary));
        TInt subT = TypeFactory.createInt(tbinary.toInt() - rightTBinary.toInt());
        assertEquals(TypeFactory.createBinary(subT.toBinary()), tbinary.sub(rightTBinary));
        TInt multT = TypeFactory.createInt(tbinary.toInt() * rightTBinary.toInt());
        assertEquals(TypeFactory.createBinary(multT.toBinary()), tbinary.mult(rightTBinary));
        if (rightTBinary.toInt() == 0) {
            rightOp = "001";
            rightTBinary = TypeFactory.createBinary("001");
        }
        TInt divT = TypeFactory.createInt(tbinary.toInt() / rightTBinary.toInt());
        assertEquals(TypeFactory.createBinary(divT.toBinary()), tbinary.div(rightTBinary));

        // OR y AND
        bin = tbinary.toString();
        int blength = bin.length();
        int rlength = rightOp.length();
        int retSize = Math.max(blength, rlength);
        if (blength < rlength){
            char sign = bin.charAt(0);
            char[] ext = new char[retSize];
            for (int i=0; i < retSize; i++) {
                if (i < (rlength - blength)) {
                    ext[i] = sign;
                }
                else {
                    ext[i] = bin.charAt(i - (rlength - blength));
                }
            }
            bin = new String(ext);
        }
        else if (rlength < blength) {
            char sign = rightOp.charAt(0);
            char[] ext = new char[retSize];
            for (int i=0; i < retSize; i++) {
                if (i < (blength - rlength)) {
                    ext[i] = sign;
                } else {
                    ext[i] = rightOp.charAt(i - (blength - rlength));
                }
            }
            rightOp = new String(ext);
        }

        char[] retOr = new char[retSize];
        char[] retAnd = new char[retSize];
        for (int j = 0; j < retSize; j++) {
            if (bin.charAt(j) == '1' && rightOp.charAt(j) == '1') {
                retAnd[j] = '1';
                retOr[j] = '1';
            }
            // this condition can't be reached when both bin and rightOp chars are 1.
            else if (bin.charAt(j) == '1' || rightOp.charAt(j) == '1') {
                retAnd[j] = '0';
                retOr[j] = '1';
            }
            // condition reached when both bin and rightOp chars are 0.
            else {
                retAnd[j] = '0';
                retOr[j] = '0';
            }
        }

        assertEquals(TypeFactory.createBinary(String.valueOf(retOr)), tbinary.or(rightTBinary));
        assertEquals(TypeFactory.createBinary(String.valueOf(retAnd)), tbinary.and(rightTBinary));

    }

}