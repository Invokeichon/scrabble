package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/**
 * Class that represents a Scrabble Int. Stores a Java int.
 */
public class TInt implements IType, INumberOps, INonDouble{
    private int value;

    /**
     * Constructs a new TInt object containing the
     * int provided.
     * @param arg int to be stored in the object.
     */
    public TInt (int arg) {
        this.value = arg;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    /**
     * Returns a String containing the
     * value stored in the object
     * converted into binary.
     * @return binary String
     */
    public String toBinary() {
        int i = this.value;
        int abs = Math.abs(i);
        String b = posIntToBinary(abs);
        if (i < 0) {
            b = twosComplement(b);
            return b;
        }
        return b;
    }

    /**
     * Auxiliary method to toBinary().
     * Negates the binary String and adds a one to it,
     * in order to represent its negative counterpart.
     * @param b original binary String
     * @return negative binary String
     */
    private String twosComplement(String b) {
        TBinary tr = new TBinary(b);
        tr = tr.negate();
        return tr.addByInt(new TInt(1)).toString();
    }

    /**
     * Auxiliary method to toBinary().
     * Converts a positive number into a
     * binary String
     * @param i int to be converted
     * @return binary String
     */
    public String posIntToBinary(int i) {
        char[] arr = new char[32];
        int num = i;
        int pos = 31;
        while (num != 0) {
            arr[pos] = (char)(num % 2 + '0');
            num = num / 2;
            pos--;
        }
        for (int j = 0; j <= pos ; j++) {
            arr[j] = '0';
        }

        return String.valueOf(arr);
    }

    @Override
    public TFloat toTFloat() {
        double dbl = value;
        return new TFloat(dbl);
    }

    @Override
    public INumber add(INumber num) {
        return num.addByInt(this);
    }

    @Override
    public INumber addByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) + this.value);
    }

    @Override
    public INumber addByInt(TInt num) {
        return new TInt(num.value + this.value);
    }

    @Override
    public INonDouble addByBinary(TBinary num) {
        TInt tr = new TInt(num.toInt() + this.value);
        return new TBinary(tr.toBinary());
    }

    @Override
    public INumber sub(INumber num) {
        return num.subByInt(this);
    }

    @Override
    public INumber subByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) - this.value);
    }

    @Override
    public INumber subByInt(TInt num) {
        return new TInt(num.value - this.value);
    }

    @Override
    public INonDouble subByBinary(TBinary num) {
        TInt tr = new TInt(num.toInt() - this.value);
        return new TBinary(tr.toBinary());
    }

    @Override
    public INumber mult(INumber num) {
        return num.multByInt(this);
    }

    @Override
    public INumber multByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) * this.value);
    }

    @Override
    public INumber multByInt(TInt num) {
        return new TInt(num.value * this.value);
    }

    @Override
    public INonDouble multByBinary(TBinary num) {
        TInt tr = new TInt(num.toInt() * this.value);
        return new TBinary(tr.toBinary());
    }

    @Override
    public INumber div(INumber num) {
        return num.divByInt(this);
    }

    @Override
    public INumber divByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) / this.value);
    }

    @Override
    public INumber divByInt(TInt num) {
        return new TInt(num.value / this.value);
    }

    @Override
    public INonDouble divByBinary(TBinary num) {
        TInt tr = new TInt(num.toInt() / this.value);
        return new TBinary(tr.toBinary());
    }

    @Override
    public TInt toTInt() {
        return new TInt(this.value);
    }

    @Override
    public TBinary toTBinary() {
        return new TBinary(this.toBinary());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TInt) {
            var o = (TInt) obj;
            return o.value == this.value;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(TInt.class, this.value);
    }
}
