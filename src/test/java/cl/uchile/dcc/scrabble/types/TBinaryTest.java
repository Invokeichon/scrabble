package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TBinaryTest {
    private String value = "1101001";
    private String value2 = "101001010";
    private String uno = "01";
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
    void toTFloat() {
        tst.toTFloat();
        //se implementara despues
    }

    @Test
    void negate() {
        assertEquals(new TBinary("0010110"), tst.negate());
    }

    @Test
    void toInt() {
        assertEquals(1, new TBinary(uno).toInt());
    }
    @Test
    void toBinary() {
        assertEquals(new TBinary(value), tst.toTBinary());
    }

    @Test
    void testEquals() {
        assertFalse(tst.equals(value));
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TBinary(value2)));
    }
}