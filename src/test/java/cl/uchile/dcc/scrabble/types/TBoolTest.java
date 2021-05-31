package cl.uchile.dcc.scrabble.types;

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
        tbool = new TBool(b);
    }

    @RepeatedTest(10)
    void constructorTest() {
        TBool expectedTBool = new TBool(b);
        assertEquals(expectedTBool, tbool);
        assertEquals(expectedTBool.hashCode(), tbool.hashCode());
        boolean differentBool = !b;
        TBool differentTBool = new TBool(differentBool);
        assertNotEquals(differentTBool, tbool);
        assertNotEquals(differentBool, tbool);
    }

    @RepeatedTest(10)
    void testToTString() {
        assertEquals(new TString(String.valueOf(b)), tbool.toTString());
        assertNotEquals(new TString(String.valueOf(!b)), tbool.toTString());
    }

    @RepeatedTest(10)
    void testToString() {
        assertEquals(String.valueOf(b), tbool.toString());
        assertNotEquals(String.valueOf(!b), tbool.toString());
    }

    @RepeatedTest(10)
    void testNegate(){
        assertEquals(tbool, tbool.negate().negate());
        assertEquals(new TBool(!b), tbool.negate());
        assertNotEquals(tbool, tbool.negate());
    }

    @RepeatedTest(10)
    void toTBool() {
        assertEquals(new TBool(b), tbool.toTBool());
        assertEquals(tbool, tbool.toTBool());
    }

    @RepeatedTest(10)
    void operationsTest() {
        boolean rightOp = rng.nextBoolean();
        TBool rightTBool = new TBool(rightOp);
        assertEquals(new TBool(b || rightOp), tbool.or(rightTBool));
        assertEquals(new TBool(b && rightOp), tbool.and(rightTBool));
    }

}