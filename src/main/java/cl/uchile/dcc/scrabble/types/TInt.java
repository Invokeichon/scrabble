package cl.uchile.dcc.scrabble.types;

public class TInt implements IType, INumber, INonDouble{
    private int value;

    /**
     * Retorna un objeto TInt con el valor entregado.
     * @param arg int a almacenar
     */
    public TInt (int arg) {
        this.value = arg;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public String toBinary() {
        int i = this.value;
        int abs = Math.abs(i);
        String b = posIntToBinary(abs);
        if (i < 0) {
            b = twosComplement(b);
        }
        return b;
    }

    private String twosComplement(String b) {
        TBinary tr = new TBinary(b);
        tr = tr.negate();
        tr = (TBinary) tr.addByBinary(new TBinary("01"));
        return tr.toString();
    }

    private String posIntToBinary(int i) {
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
        return new TFloat(Float.parseFloat(num.toString()) * this.value);
    }

    @Override
    public INumber subByInt(TInt num) {
        return new TInt(num.value + this.value);
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

    /**
     * Retorna el valor almacenado en el objeto como un int.
     * @return int
     */
    public TInt toTInt() {
        return new TInt(this.value);
    }

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
}
