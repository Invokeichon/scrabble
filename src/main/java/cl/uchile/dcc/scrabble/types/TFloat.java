package cl.uchile.dcc.scrabble.types;

public class TFloat implements IType, INumber{
    private double value;

    /**
     * Retorna un TFloat que contiene el valor entregado.
     * @param arg double a almacenar
     */
    public TFloat(double arg){
        this.value = arg;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public double toFloat() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TFloat) {
            var o = (TFloat) obj;
            return o.toFloat() == this.toFloat();
        }
        else {
            return false;
        }
    }
}
