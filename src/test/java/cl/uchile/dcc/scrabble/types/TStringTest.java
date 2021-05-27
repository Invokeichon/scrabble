package cl.uchile.dcc.scrabble.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TStringTest {
    private String value = "Hola";
    private String value2 = "Chao";
    private TString tst;

    @BeforeEach
    void setUp() {
        tst = new TString(value);
    }

    @Test
    void testToString() {
        assertEquals(value, tst.toString());
    }

    @Test
    void testAdd() {
        TBool tstbool = new TBool(true);
        assertEquals(new TString("Holatrue"), tst.add(tstbool));
        TFloat tstfloat = new TFloat(10.324);
        assertEquals(new TString("Hola10.324"), tst.add(tstfloat));
        TInt tstint = new TInt(666);
        assertEquals(new TString("Hola666"), tst.add(tstint));
    }

    @Test
    void testEquals() {
        assertTrue(tst.equals(tst));
        assertFalse(tst.equals(new TString(value2)));
        assertFalse(tst.equals(new TBinary(value)));
    }
}