package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TBinaryTest {
    private String value = "1101001";
    private String value2 = "101001010";
    private TBinary tst;

    @BeforeEach
    void setUp() {
        tst = new TBinary(value);
    }

    @Test
    void testToString() {
        assertEquals(value, tst.toString());
    }

    @Test
    void toFloat() {
        tst.toFloat();
        //se implementara despues
    }

    @Test
    void toBinary() {
        assertEquals(value, tst.toBinary());
    }

    @Test
    void testEquals() {
        assertFalse(tst.equals(value));
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TBinary(value2)));
    }
}