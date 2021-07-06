package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TBoolTest {
    private TBool tbool;
    private boolean b;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        b = rng.nextBoolean();
        tbool = TypeFactory.createBool(b);
    }

    @RepeatedTest(10)
    void constructorTest() {
        TBool expectedTBool = TypeFactory.createBool(b);
        assertEquals(expectedTBool, tbool);
        assertEquals(expectedTBool.hashCode(), tbool.hashCode());
        boolean differentBool = !b;
        TBool differentTBool = TypeFactory.createBool(differentBool);
        assertNotEquals(differentTBool, tbool);
        assertNotEquals(differentBool, tbool);
    }

    @RepeatedTest(10)
    void testToTString() {
        assertEquals(TypeFactory.createString(String.valueOf(b)), tbool.toTString());
        assertNotEquals(TypeFactory.createString(String.valueOf(!b)), tbool.toTString());
    }

    @RepeatedTest(10)
    void testToString() {
        assertEquals(String.valueOf(b), tbool.toString());
        assertNotEquals(String.valueOf(!b), tbool.toString());
    }

    @RepeatedTest(10)
    void testNegate(){
        assertEquals(tbool, tbool.negate().negate());
        assertEquals(TypeFactory.createBool(!b), tbool.negate());
        assertNotEquals(tbool, tbool.negate());
    }

    @RepeatedTest(10)
    void toTBool() {
        assertEquals(TypeFactory.createBool(b), tbool.toTBool());
        assertEquals(tbool, tbool.toTBool());
    }

    @RepeatedTest(10)
    void operationsTest() {
        boolean rightOp = rng.nextBoolean();
        TBool rightTBool = TypeFactory.createBool(rightOp);
        assertEquals(TypeFactory.createBool(b || rightOp), tbool.or(rightTBool));
        assertEquals(TypeFactory.createBool(b && rightOp), tbool.and(rightTBool));
    }

}