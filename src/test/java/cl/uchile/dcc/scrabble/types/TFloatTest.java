package cl.uchile.dcc.scrabble.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TFloatTest {
    private double dbl;
    private TFloat tfloat;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        dbl = rng.nextDouble();
        tfloat = new TFloat(dbl);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TFloat expectedTFloat = new TFloat(dbl);
        assertEquals(expectedTFloat, tfloat);
        assertEquals(expectedTFloat.hashCode(), tfloat.hashCode());
        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == dbl);
        TFloat differentTFloat = new TFloat(differentDouble);
        assertNotEquals(differentTFloat, tfloat);
        assertNotEquals(differentDouble, tfloat);
    }

    @RepeatedTest(20)
    void testToString() {
        int strSize = rng.nextInt(15);
        String differentString;
        do {differentString = RandomStringUtils.random(strSize,0,0,false,
                true, null, rng);
        } while (differentString.equals(String.valueOf(dbl)));
        assertEquals(String.valueOf(dbl), tfloat.toString());
        assertNotEquals(differentString, tfloat.toString());
    }

    @RepeatedTest(20)
    void testToTString() {
        int strSize = rng.nextInt(15);
        String differentString;
        do {differentString = RandomStringUtils.random(strSize,0,0,false,
                true, null, rng);
        } while (differentString.equals(String.valueOf(dbl)));
        assertEquals(new TString(String.valueOf(dbl)), tfloat.toTString());
        assertNotEquals(new TString(differentString), tfloat.toTString());
    }

    @RepeatedTest(20)
    void operationsTest() {
        double rightOp;
        rightOp = rng.nextDouble();
        TFloat rightTFloat = new TFloat(rightOp);
        assertEquals(new TFloat(dbl + rightOp), tfloat.add(rightTFloat));
        assertEquals(new TFloat(dbl - rightOp), tfloat.sub(rightTFloat));
        assertEquals(new TFloat(dbl * rightOp), tfloat.mult(rightTFloat));
        assertEquals(new TFloat(dbl / rightOp), tfloat.div(rightTFloat));

    }

    @RepeatedTest(20)
    void testToTFloat() {
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        } while (differentFloat == dbl);
        assertEquals(new TFloat(dbl), tfloat.toTFloat());
        assertNotEquals(new TFloat(differentFloat), tfloat.toTFloat());
    }

}