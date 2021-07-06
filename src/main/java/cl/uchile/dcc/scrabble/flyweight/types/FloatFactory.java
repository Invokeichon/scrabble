package cl.uchile.dcc.scrabble.flyweight.types;

import cl.uchile.dcc.scrabble.types.TFloat;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Creates TFloat objects in a memory-saving fashion, avoiding creating new
 * objects if an equal one has already been instanced.
 */
public class FloatFactory {
    private Map<Double, TFloat> mem;

    /**
     * Every instance created has its own dictionary (or "memory") that discerns whether
     * a new TFloat object should be created or not.
     */
    public FloatFactory(){
        mem = new HashMap<>();
    }

    /**
     * Creates (or reuses) a TFloat object.
     * Checks if the TFloat looking to be created already exists within its memory.
     * If so, simply returns the TFloat stored in the dictionary.
     * Otherwise, a new TFloat object is created, returned, and then stored in memory
     * for future calls.
     */
    public TFloat create(double d) {
        if (mem.containsKey(d)) {
            return mem.get(d);
        }
        else {
            TFloat type = new TFloat(d);
            mem.put(d, type);
            return type;
        }
    }
}
