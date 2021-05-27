package cl.uchile.dcc.scrabble.types;

public class TBinary implements IType, INumber, ILogic, INonDouble {
    private String value;

    /**
     * Constructor que retorna un objeto TBinary almacenando
     * el valor entregado.
     * @param binary binario a almacenar
     */
    public TBinary (String binary) {
        this.value = binary;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public TFloat toTFloat() {
        int i = this.toInt();
        double d = i;
        return new TFloat(d);
    }

    public TInt toTInt() {
        return new TInt(this.toInt());
    }

    public int toInt() {
        String binary = this.value;
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinToInt(binary);
        }
    }
    private int negativeBinToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    private void binExtend(int size) {
        int len = this.value.length();
        if (size <= len) {
            return;
        }
        char[] ext = new char[size];
        char sign = this.value.charAt(0);
        for (int i=0; i < size; i++) {
            if(i < len) {
                ext[i] = sign;
            }
            else {
                ext[i] = this.value.charAt(i - len);
            }
        }
        this.value = new String(ext);
    }

    @Override
    public INumber add(INumber num) {
        INonDouble tr = (INonDouble) num;
        return (INumber) tr.addByBinary(this);
    }

    @Override
    public INumber addByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) + (double) this.toInt());
    }

    @Override
    public INumber addByInt(TInt num) {
        return new TInt(Integer.parseInt(num.toString()) + this.toInt());
    }

    @Override
    public INonDouble addByBinary(TBinary num) {
        TInt calc = new TInt(num.toInt() + this.toInt());
        return new TBinary(calc.toBinary());
    }

    @Override
    public INumber sub(INumber num) {
        INonDouble tr = (INonDouble) num;
        return (INumber) tr.subByBinary(this);
    }

    @Override
    public INumber subByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) - (double) this.toInt());
    }

    @Override
    public INumber subByInt(TInt num) {
        return new TInt(Integer.parseInt(num.toString()) - this.toInt());
    }

    @Override
    public INonDouble subByBinary(TBinary num) {
        TInt calc = new TInt(num.toInt() - this.toInt());
        return new TBinary(calc.toBinary());
    }


    @Override
    public INumber mult(INumber num) {
        INonDouble tr = (INonDouble) num;
        return (INumber) tr.multByBinary(this);
    }

    @Override
    public INumber multByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) * (double) this.toInt());
    }

    @Override
    public INumber multByInt(TInt num) {
        return new TInt(Integer.parseInt(num.toString()) * this.toInt());
    }

    @Override
    public INonDouble multByBinary(TBinary num) {
        TInt calc = new TInt(num.toInt() * this.toInt());
        return new TBinary(calc.toBinary());
    }

    @Override
    public INumber div(INumber num) {
        INonDouble tr = (INonDouble) num;
        return (INumber) tr.divByBinary(this);
    }

    @Override
    public INumber divByFloat(TFloat num) {
        return new TFloat(Float.parseFloat(num.toString()) / (double) this.toInt());
    }

    @Override
    public INumber divByInt(TInt num) {
        return new TInt(Integer.parseInt(num.toString()) / this.toInt());
    }

    @Override
    public INonDouble divByBinary(TBinary num) {
        TInt calc = new TInt(num.toInt() / this.toInt());
        return new TBinary(calc.toBinary());
    }


    /**
     * Retorna el valor almacenado como un binario (string de 0s y 1s)
     * @return binary
     */
    public TBinary toTBinary() {
        return new TBinary(this.value);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TBinary) {
            var o = (TBinary) obj;
            return o.value.equals(this.value);
        }
        else {
            return false;
        }
    }

    @Override
    public ILogic and(ILogic p) {
        return p.andByBinary(this);
    }

    @Override
    public ILogic andByBool(TBool b) {
        char bool = boolToBin(Boolean.parseBoolean(b.toString()));
        char[] bin = this.value.toCharArray();
        for (int i = 0; i < bin.length ; i++ ) {
            if ( bool == '1' && bin[i] == '1') {
                bin[i] = '1';
            }
            else { bin[i] = '0'; }
        }
        return new TBinary(String.valueOf(bin));
    }

    @Override
    public ILogic andByBinary(TBinary b) {
        b.binExtend(this.value.length());
        this.binExtend(b.value.length());
        int size = Math.max(this.value.length(), b.value.length());
        char[] ret = new char[size];
        for (int i = 0; i < size; i++) {
            if (b.value.charAt(i) == '1' && this.value.charAt(i) == '1') {
                ret[i] = '1';
            }
            else {
                ret[i] = '0';
            }

        }
        return new TBinary(new String(ret));
    }

    @Override
    public ILogic or(ILogic p) {
        return p.orByBinary(this);
    }

    @Override
    public ILogic orByBool(TBool b) {
        char bool = boolToBin(Boolean.parseBoolean(b.toString()));
        char[] bin = this.value.toCharArray();
        for (int i = 0; i < bin.length ; i++ ) {
            if ( bool == '1' || bin[i] == '1') {
                bin[i] = '1';
            }
            else { bin[i] = '0'; }
        }
        return new TBinary(String.valueOf(bin));
    }

    @Override
    public ILogic orByBinary(TBinary b) {
        b.binExtend(this.value.length());
        this.binExtend(b.value.length());
        int size = Math.max(this.value.length(), b.value.length());
        char[] ret = new char[size];
        for (int i = 0; i < size; i++) {
            if (b.value.charAt(i) == '1' || this.value.charAt(i) == '1') {
                ret[i] = '1';
            }
            else {
                ret[i] = '0';
            }

        }
        return new TBinary(new String(ret));
    }

    @Override
    public TBinary negate() {
        char[] binary = this.value.toCharArray();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '0') {
                binary[i] = '1';
            }
            else {
                binary[i] = '0';
            }
        }
        String newval = String.valueOf(binary);
        return new TBinary(newval);
    }
}
