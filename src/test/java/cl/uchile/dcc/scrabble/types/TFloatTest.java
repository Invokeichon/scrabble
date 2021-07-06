package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
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
        tfloat = TypeFactory.createFloat(dbl);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TFloat expectedTFloat = TypeFactory.createFloat(dbl);
        assertEquals(expectedTFloat, tfloat);
        assertEquals(expectedTFloat.hashCode(), tfloat.hashCode());
        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == dbl);
        TFloat differentTFloat = TypeFactory.createFloat(differentDouble);
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
        assertEquals(TypeFactory.createString(String.valueOf(dbl)), tfloat.toTString());
        assertNotEquals(TypeFactory.createString(differentString), tfloat.toTString());
    }

    @RepeatedTest(20)
    void operationsTest() {
        double rightOp;
        rightOp = rng.nextDouble();
        TFloat rightTFloat = TypeFactory.createFloat(rightOp);
        assertEquals(TypeFactory.createFloat(dbl + rightOp), tfloat.add(rightTFloat));
        assertEquals(TypeFactory.createFloat(dbl - rightOp), tfloat.sub(rightTFloat));
        assertEquals(TypeFactory.createFloat(dbl * rightOp), tfloat.mult(rightTFloat));
        assertEquals(TypeFactory.createFloat(dbl / rightOp), tfloat.div(rightTFloat));

    }

    @RepeatedTest(20)
    void testToTFloat() {
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        } while (differentFloat == dbl);
        assertEquals(TypeFactory.createFloat(dbl), tfloat.toTFloat());
        assertNotEquals(TypeFactory.createFloat(differentFloat), tfloat.toTFloat());
    }

}