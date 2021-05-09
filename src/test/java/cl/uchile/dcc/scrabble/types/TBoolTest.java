package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TBoolTest {
    private boolean value = false;
    private boolean value2 = true;
    private TBool tst;

    @BeforeEach
    void constructorTest() {
        tst = new TBool(value);
    }

    @Test
    void testToString() {
        assertEquals("false", tst.toString());
    }

    @Test
    void toBool() {
        assertEquals(value, tst.toBool());
    }

    @Test
    void testEquals() {
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TBool(value2)));
        assertFalse(tst.equals(new TString("test")));
    }
}