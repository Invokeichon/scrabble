package cl.uchile.dcc.scrabble.flyweight.types;

import cl.uchile.dcc.scrabble.types.TString;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Creates TString objects in a memory-saving fashion, avoiding creating new
 * objects if an equal one has already been instanced.
 */
public class StringFactory {
    private Map<String, TString> mem;

    /**
     * Every instance created has its own dictionary (or "memory") that discerns whether
     * a new TString object should be created or not.
     */
    public StringFactory(){
        mem = new HashMap<>();
    }

    /**
     * Creates (or reuses) a TString object.
     * Checks if the TString looking to be created already exists within its memory.
     * If so, simply returns the TString stored in the dictionary.
     * Otherwise, a new TString object is created, returned, and then stored in memory
     * for future calls.
     */
    public TString create(String str) {
        if (mem.containsKey(str)) {
            return mem.get(str);
        }
        else {
            TString type = new TString(str);
            mem.put(str, type);
            return type;
        }
    }
}
