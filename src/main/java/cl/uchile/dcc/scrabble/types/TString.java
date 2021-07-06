package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.interfaces.IType;
import cl.uchile.dcc.scrabble.types.interfaces.ITypeOps;

import java.util.Objects;

/**
 * Class that represents a Scrabble String. Stores a Java String.
 */
public class TString implements ITypeOps {
    private String value;

    /**
     * Constructs a TypeFactory.createString object containing the
     * String provided.
     * @param str String to be stored
     */
    public TString (String str) {
        this.value = str;
    }

    @Override
    public TString add(IType t){
        return t.addedByString(this);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TString) {
            var o = (TString) obj;
            return o.toString().equals(this.toString());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(TString.class, this.value);
    }
}