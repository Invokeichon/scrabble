package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TIntTest {
    private int value = 12;
    private int value2 = 666;
    private String sval = "12";
    private double fval = 12.0;
    private TInt tst;

    @BeforeEach
    void constructorTest() {
        tst = new TInt(value);
    }

    @Test
    void testToString() {
        assertEquals(sval, tst.toString());
    }

    @Test
    void toFloat() {
        assertEquals(fval, tst.toFloat());
        assertNotEquals(value2, tst.toFloat());
    }

    @Test
    void toInt() {
        assertEquals(value, tst.toInt());
        assertNotEquals(value2, tst.toInt());
    }

    @Test
    void testEquals() {
        assertFalse(tst.equals(sval));
        assertFalse(tst.equals(new TInt(value2)));
        assertTrue(tst.equals(tst));
    }
}