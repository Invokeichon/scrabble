package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TStringTest {
    private String value = "Hola";
    private String value2 = "Chao";
    private TString tst;

    @BeforeEach
    void constructorTest() {
        tst = new TString(value);
    }

    @Test
    void testToString() {
        assertEquals(value, tst.toString());
    }

    @Test
    void testEquals() {
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TString(value2)));
        assertFalse(tst.equals(new TBinary(value)));
    }
}