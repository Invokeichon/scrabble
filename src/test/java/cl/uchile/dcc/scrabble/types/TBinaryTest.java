package cl.uchile.dcc.scrabble.types;

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
        tbinary = new TBinary(bin);
    }

    @RepeatedTest(20)
    void constructorTest() {
        var expectedTBinary = new TBinary (bin);
        assertEquals(expectedTBinary, tbinary);
        assertEquals(expectedTBinary.hashCode(), tbinary.hashCode(), "Hash Codes don't match.");
        int diffSize;
        String differentBin;
        do {
            diffSize = rng.nextInt(32);
            differentBin = RandomStringUtils.random(diffSize, 0, 0,
                    false, true, bins, rng);
        } while (differentBin.equals(bin) || diffSize == 0 || diffSize == 1);
        TBinary differentTBinary = new TBinary(differentBin);
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
        assertEquals(new TString(bin), tbinary.toTString());
        assertNotEquals(new TString(differentString), tbinary.toTString());
    }

    @RepeatedTest(20)
    void testToTFloat() {
        double tr = tbinary.toInt();
        double diff;
        do {diff = rng.nextDouble();} while (diff == tr);
        assertEquals(new TFloat(tr), tbinary.toTFloat());
        assertNotEquals(new TFloat(diff), tbinary.toTFloat());

    }

    @RepeatedTest(20)
    void testToTInt() {
        int tr = tbinary.toInt();
        int diff;
        do {diff = rng.nextInt();} while (diff == tr);
        assertEquals(new TInt(tr), tbinary.toTInt());
        assertNotEquals(new TInt(diff), tbinary.toTInt());
    }

    @RepeatedTest(20)
    void testToTBinary() {
        int binSize = rng.nextInt(32);
        String differentString;
        do {differentString = RandomStringUtils.random(binSize,0,0,false,
                true, bins, rng);
        } while (differentString.equals(bin));
        assertEquals(new TBinary(bin), tbinary.toTBinary());
        assertNotEquals(new TBinary(differentString), tbinary.toTBinary());
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
        TBinary rightTBinary = new TBinary(rightOp);
        TInt addT = new TInt(tbinary.toInt() + rightTBinary.toInt());
        assertEquals(new TBinary(addT.toBinary()), tbinary.add(rightTBinary));
        TInt subT = new TInt(tbinary.toInt() - rightTBinary.toInt());
        assertEquals(new TBinary(subT.toBinary()), tbinary.sub(rightTBinary));
        TInt multT = new TInt(tbinary.toInt() * rightTBinary.toInt());
        assertEquals(new TBinary(multT.toBinary()), tbinary.mult(rightTBinary));
        if (rightTBinary.toInt() == 0) {
            rightOp = "001";
            rightTBinary = new TBinary("001");
        }
        TInt divT = new TInt(tbinary.toInt() / rightTBinary.toInt());
        assertEquals(new TBinary(divT.toBinary()), tbinary.div(rightTBinary));

        // OR y AND
        bin = tbinary.toString();
        int blength = bin.length();
        int rlength = rightOp.length();
        int retSize = Math.max(blength, rlength);
        System.out.println(bin);
        System.out.println(rightOp);
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
        System.out.println(bin);
        System.out.println(rightOp);
        System.out.println("----------------");
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

        assertEquals(new TBinary(String.valueOf(retOr)), tbinary.or(rightTBinary));
        assertEquals(new TBinary(String.valueOf(retAnd)), tbinary.and(rightTBinary));

    }

}