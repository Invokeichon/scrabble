package cl.uchile.dcc.scrabble.flyweight.types;

import cl.uchile.dcc.scrabble.types.TInt;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Creates TInt objects in a memory-saving fashion, avoiding creating new
 * objects if an equal one has already been instanced.
 */
public class IntFactory {
    private Map<Integer, TInt> mem;

    /**
     * Every instance created has its own dictionary (or "memory") that discerns whether
     * a new TInt object should be created or not.
     */
    public IntFactory(){
        mem = new HashMap<>();
    }

    /**
     * Creates (or reuses) a TInt object.
     * Checks if the TInt looking to be created already exists within its memory.
     * If so, simply returns the TInt stored in the dictionary.
     * Otherwise, a new TInt object is created, returned, and then stored in memory
     * for future calls.
     */
    public TInt create(int i) {
        if (mem.containsKey(i)) {
            return mem.get(i);
        }
        else {
            TInt type = new TInt(i);
            mem.put(i, type);
            return type;
        }
    }
}
