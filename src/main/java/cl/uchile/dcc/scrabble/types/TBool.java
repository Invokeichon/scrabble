package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/**
 * Class that represents a Scrabble Bool. Stores a Java boolean.
 */
public class TBool implements IType, ILogic{
    private boolean value;

    /**
     * Constructs a new TBool object containing the
     * boolean provided.
     * @param bool boolean to be stored in the object
     */
    public TBool (boolean bool) {
        this.value = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    /**
     * Returns a new TBool object storing the value of
     * the caller object converted to boolean
     * @return TBool object
     */
    public TBool toTBool() {
        return new TBool(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TBool) {
            var o = (TBool) obj;
            return o.value == this.value;
        }
        else {
            return false;
        }
    }

    @Override
    public ILogic and(ILogic p) {
        return p.andByBool(this);
    }

    @Override
    public ILogic andByBool(TBool b) {
        return new TBool(this.value && b.value);
    }

    @Override
    public ILogic andByBinary(TBinary b) {
        char bool = boolToBin(this.value);
        char[] bin = b.toString().toCharArray();
        for (int i = 0; i < bin.length ; i++ ) {
            if ( bool == '1' && bin[i] == '1') {
                bin[i] = '1';
            }
            else { bin[i] = '0'; }
        }
        return new TBinary(String.valueOf(bin));
    }

    @Override
    public ILogic or(ILogic p) {
        return p.orByBool(this);
    }

    @Override
    public ILogic orByBool(TBool b) {
        return new TBool(this.value || b.value);
    }

    @Override
    public ILogic orByBinary(TBinary b) {
        char bool = boolToBin(this.value);
        char[] bin = b.toString().toCharArray();
        for (int i = 0; i < bin.length ; i++ ) {
            if ( bool == '1' || bin[i] == '1') {
                bin[i] = '1';
            }
            else { bin[i] = '0'; }
        }
        return new TBinary(String.valueOf(bin));
    }

    @Override
    public TBool negate() {
        return new TBool(!this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TBool.class, this.value);
    }
}
