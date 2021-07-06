package cl.uchile.dcc.scrabble.flyweight.types;

import cl.uchile.dcc.scrabble.types.TBool;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Creates TBool objects in a memory-saving fashion, avoiding creating new
 * objects if an equal one has already been instanced.
 */
public class BoolFactory {
    private Map<Boolean, TBool> mem;

    /**
     * Every instance created has its own dictionary (or "memory") that discerns whether
     * a new TBool object should be created or not.
     */
    public BoolFactory() {
        mem = new HashMap<>();
    }

    /**
     * Creates (or reuses) a TBool object.
     * Checks if the TBool looking to be created already exists within its memory.
     * If so, simply returns the TBool stored in the dictionary.
     * Otherwise, a new TBool object is created, returned, and then stored in memory
     * for future calls.
     */
    public TBool create(boolean b) {
        if (mem.containsKey(b)) {
            return mem.get(b);
        }
        else {
            TBool type = new TBool(b);
            mem.put(b, type);
            return type;
        }
    }
}
