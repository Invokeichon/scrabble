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
    void setUp() {
        tst = new TInt(value);
    }

    @Test
    void testToString() {
        assertEquals(sval, tst.toString());
    }

    @Test
    void toFloat() {
        assertEquals(new TFloat(fval), tst.toTFloat());
    }

    @Test
    void toInt() {
        assertEquals(new TInt(value), tst.toTInt());
        assertNotEquals(new TInt(value2), tst.toTInt());
    }

    @Test
    void toBinary() {
        assertEquals("00000000000000000000000000000001", new TInt(1).toBinary());
    }

    @Test
    void testEquals() {
        assertFalse(tst.equals(sval));
        assertFalse(tst.equals(new TInt(value2)));
        assertTrue(tst.equals(tst));
    }
}