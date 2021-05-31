package cl.uchile.dcc.scrabble.types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TStringTest {
    private String str;
    private TString tstring;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        tstring = new TString(str);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TString expectedTString = new TString(str);
        assertEquals(expectedTString, tstring);
        assertEquals(expectedTString.hashCode(), tstring.hashCode());
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        TString differentTString = new TString(differentString);
        assertNotEquals(differentTString, tstring);
        assertNotEquals(differentString, tstring);
    }

    @RepeatedTest(20)
    void testToString() {
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        assertEquals(str, tstring.toString());
        assertNotEquals(differentString, tstring.toString());
    }

    @RepeatedTest(20)
    void testToTString() {
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        assertEquals(new TString(str), tstring.toTString());
        assertNotEquals(new TString(differentString), tstring.toTString());
    }



    @RepeatedTest(20)
    void testAdd() {
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        TString addedTString = new TString(differentString);
        assertEquals(new TString(str + differentString), tstring.add(addedTString));
    }

}