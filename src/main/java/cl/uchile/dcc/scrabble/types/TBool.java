package cl.uchile.dcc.scrabble.types;

public class TBool implements IType, ILogic{
    private boolean value;

    /**
     * Retorna un objeto TBool con el valor (boolean) entregado.
     * @param bool valor a almacenar
     */
    public TBool (boolean bool) {
        this.value = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    /**
     * Entrega el valor almacenado convertido a boolean
     * @return boolean
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
}
