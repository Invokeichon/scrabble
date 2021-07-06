package cl.uchile.dcc.scrabble.flyweight.types;

import cl.uchile.dcc.scrabble.types.TBinary;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Creates TBinary objects in a memory-saving fashion, avoiding creating new
 * objects if an equal one has already been instanced.
 */
public class BinaryFactory {
    private Map<String, TBinary> mem;

    /**
     * Every instance created has its own dictionary (or "memory") that discerns whether
     * a new TBinary object should be created or not.
     */
    public BinaryFactory(){
        mem = new HashMap<>();
    }

    /**
     * Creates (or reuses) a TBinary object.
     * Checks if the TBinary looking to be created already exists within its memory.
     * If so, simply returns the TBinary stored in the dictionary.
     * Otherwise, a new TBinary object is created, returned, and then stored in memory
     * for future calls.
     */
    public TBinary create(String bin) {
        if (mem.containsKey(bin)) {
            return mem.get(bin);
        }
        else {
            TBinary type = new TBinary(bin);
            mem.put(bin, type);
            return type;
        }
    }
}
