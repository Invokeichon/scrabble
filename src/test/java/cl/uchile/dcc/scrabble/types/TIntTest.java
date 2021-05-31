package cl.uchile.dcc.scrabble.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TIntTest {
    private int seed;
    private Random rng;
    private TInt tint;
    private int value;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        value = rng.nextInt();
        tint = new TInt(value);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TInt expectedTInt = new TInt(value);
        assertEquals(expectedTInt, tint);
        assertEquals(expectedTInt.hashCode(), tint.hashCode());
        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == value);
        TInt differentTInt = new TInt(differentInt);
        assertNotEquals(differentTInt, tint);
        assertNotEquals(differentInt, tint);
    }

    @RepeatedTest(20)
    void testToString() {
        int strSize = rng.nextInt(15);
        String differentString;
        do {differentString = RandomStringUtils.random(strSize,0,0,false,
                true, null, rng);
        } while (differentString.equals(String.valueOf(value)));
        assertEquals(String.valueOf(value), tint.toString());
        assertNotEquals(differentString, tint.toString());
    }

    @RepeatedTest(20)
    void testToTString() {
        int strSize = rng.nextInt(15);
        String differentString;
        do {differentString = RandomStringUtils.random(strSize,0,0,false,
                true, null, rng);
        } while (differentString.equals(String.valueOf(value)));
        assertEquals(new TString(String.valueOf(value)), tint.toTString());
        assertNotEquals(new TString(differentString), tint.toTString());
    }

    @RepeatedTest(20)
    void operationsTest() {
        int rightOp;
        rightOp = rng.nextInt();
        TInt rightTInt = new TInt(rightOp);
        assertEquals(new TInt(value + rightOp), tint.add(rightTInt));
        assertEquals(new TInt(value - rightOp), tint.sub(rightTInt));
        assertEquals(new TInt(value * rightOp), tint.mult(rightTInt));
        assertEquals(new TInt(value / rightOp), tint.div(rightTInt));
    }

    @RepeatedTest(20)
    void testToTFloat() {
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        } while (differentFloat == value);
        assertEquals(new TFloat(value), tint.toTFloat());
        assertNotEquals(new TFloat(differentFloat), tint.toTFloat());
    }

    @RepeatedTest(20)
    void testToTInt() {
        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == value);
        assertEquals(new TInt(value), tint.toTInt());
        assertNotEquals(new TInt(differentInt), tint.toTInt());
        assertEquals(tint, tint.toTInt());
    }

    @RepeatedTest(20)
    void testToTBinary() {
        assertEquals(new TBinary(tint.toBinary()), tint.toTBinary());
    }
}