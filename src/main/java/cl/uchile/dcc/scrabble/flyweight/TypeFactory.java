package cl.uchile.dcc.scrabble.flyweight;

import cl.uchile.dcc.scrabble.types.*;
import cl.uchile.dcc.scrabble.flyweight.types.*;

/**
 * Flyweight Factory.
 * Serves as a hub for all type creations, through storing an instance of
 * every Factory (one for each type).
 * As such, it maintains a global "mem" of Types created.
 * If looking to create local mem instance individual type factories.
 * This class is not meant to be instanced.
 */
public class TypeFactory {
    private static StringFactory stringFactory = new StringFactory();
    private static BoolFactory boolFactory = new BoolFactory();
    private static BinaryFactory binaryFactory = new BinaryFactory();
    private static IntFactory intFactory = new IntFactory();
    private static FloatFactory floatFactory = new FloatFactory();

    /**
     * Returns a TString using StringFactory, which checks if
     * it needs to be created or not.
     */
    public static TString createString(String str) {
        return stringFactory.create(str);
    }

    /**
     * Returns a TBool using BoolFactory, which checks if
     * it needs to be created or not.
     */
    public static TBool createBool(boolean b) {
        return boolFactory.create(b);
    }

    /**
     * Returns a TBinary using BinaryFactory, which checks if
     * it needs to be created or not.
     */
    public static TBinary createBinary(String bin) {
        return binaryFactory.create(bin);
    }

    /**
     * Returns a TInt using IntFactory, which checks if
     * it needs to be created or not.
     */
    public static TInt createInt(int i) {
        return intFactory.create(i);
    }

    /**
     * Returns a TFloat using FloatFactory, which checks if
     * it needs to be created or not.
     */
    public static TFloat createFloat(double d) {
        return floatFactory.create(d);
    }
}
