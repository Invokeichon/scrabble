package cl.uchile.dcc.scrabble.types;

public class TInt implements IType, INumber{
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

    @Override
    public double toFloat() {
        double dbl = value;
        return dbl;
    }

    /**
     * Retorna el valor almacenado en el objeto como un int.
     * @return int
     */
    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TInt) {
            var o = (TInt) obj;
            return o.toInt() == this.toInt();
        }
        else {
            return false;
        }
    }
}
