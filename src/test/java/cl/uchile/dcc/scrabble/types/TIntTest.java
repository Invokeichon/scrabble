package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
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
        tint = TypeFactory.createInt(value);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TInt expectedTInt = TypeFactory.createInt(value);
        assertEquals(expectedTInt, tint);
        assertEquals(expectedTInt.hashCode(), tint.hashCode());
        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == value);
        TInt differentTInt = TypeFactory.createInt(differentInt);
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
        assertEquals(TypeFactory.createString(String.valueOf(value)), tint.toTString());
        assertNotEquals(TypeFactory.createString(differentString), tint.toTString());
    }

    @RepeatedTest(20)
    void operationsTest() {
        int rightOp;
        rightOp = rng.nextInt();
        TInt rightTInt = TypeFactory.createInt(rightOp);
        assertEquals(TypeFactory.createInt(value + rightOp), tint.add(rightTInt));
        assertEquals(TypeFactory.createInt(value - rightOp), tint.sub(rightTInt));
        assertEquals(TypeFactory.createInt(value * rightOp), tint.mult(rightTInt));
        assertEquals(TypeFactory.createInt(value / rightOp), tint.div(rightTInt));
    }

    @RepeatedTest(20)
    void testToTFloat() {
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        } while (differentFloat == value);
        assertEquals(TypeFactory.createFloat(value), tint.toTFloat());
        assertNotEquals(TypeFactory.createFloat(differentFloat), tint.toTFloat());
    }

    @RepeatedTest(20)
    void testToTInt() {
        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == value);
        assertEquals(TypeFactory.createInt(value), tint.toTInt());
        assertNotEquals(TypeFactory.createInt(differentInt), tint.toTInt());
        assertEquals(tint, tint.toTInt());
    }

    @RepeatedTest(20)
    void testToTBinary() {
        assertEquals(TypeFactory.createBinary(tint.toBinary()), tint.toTBinary());
    }
}