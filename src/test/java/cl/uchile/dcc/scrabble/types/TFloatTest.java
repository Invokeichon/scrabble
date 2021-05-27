package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TFloatTest {
    private double value = 3.9234;
    private double value2 = 2.4592;
    private String sval = "3.9234";
    private TFloat tst;

    @BeforeEach
    void setUp() {
        tst = new TFloat(value);
    }

    @Test
    void testToString() {
        assertEquals(sval, tst.toString());
    }

    @Test
    void toFloat() {
        assertEquals(new TFloat(value), tst.toTFloat());
    }

    @Test
    void testEquals() {
        assertFalse(tst.equals(3));
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TFloat(value2)));
    }
}