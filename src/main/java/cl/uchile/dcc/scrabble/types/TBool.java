package cl.uchile.dcc.scrabble.types;

public class TBool implements IType{
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
        return String.valueOf(value);
    }

    /**
     * Entrega el valor almacenado convertido a boolean
     * @return boolean
     */
    public boolean toBool() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TBool) {
            var o = (TBool) obj;
            return o.toBool() == this.toBool();
        }
        else {
            return false;
        }
    }
}
