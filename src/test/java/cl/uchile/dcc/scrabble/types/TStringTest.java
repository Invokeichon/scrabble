package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
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
        tstring = TypeFactory.createString(str);
    }

    @RepeatedTest(20)
    void constructorTest() {
        TString expectedTString = TypeFactory.createString(str);
        assertEquals(expectedTString, tstring);
        assertEquals(expectedTString.hashCode(), tstring.hashCode());
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        TString differentTString = TypeFactory.createString(differentString);
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
        assertEquals(TypeFactory.createString(str), tstring.toTString());
        assertNotEquals(TypeFactory.createString(differentString), tstring.toTString());
    }



    @RepeatedTest(20)
    void testAdd() {
        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT,
                    true, true, null, rng);
        } while (differentString.equals(str));
        TString addedTString = TypeFactory.createString(differentString);
        assertEquals(TypeFactory.createString(str + differentString), tstring.add(addedTString));
    }

}