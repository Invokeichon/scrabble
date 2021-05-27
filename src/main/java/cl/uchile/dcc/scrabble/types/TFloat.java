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
    public TFloat toTFloat() {
        return new TFloat(this.value);
    }

    @Override
    public INumber add(INumber num) {
        return num.addByFloat(this);
    }

    @Override
    public INumber addByFloat(TFloat num) {
        return new TFloat(this.value + num.value);
    }

    @Override
    public INumber addByInt(TInt num) {
        return new TFloat(this.value + Integer.parseInt(num.toString()));
    }

    @Override
    public INumber sub(INumber num) {
        return num.subByFloat(this);
    }

    @Override
    public INumber subByFloat(TFloat num) {
        return new TFloat(this.value - num.value);
    }

    @Override
    public INumber subByInt(TInt num) {
        return new TFloat(this.value - Integer.parseInt(num.toString()));
    }

    @Override
    public INumber mult(INumber num) {
        return num.multByFloat(this);
    }

    @Override
    public INumber multByFloat(TFloat num) {
        return new TFloat(this.value * num.value);
    }

    @Override
    public INumber multByInt(TInt num) {
        return new TFloat(this.value * Integer.parseInt(num.toString()));
    }

    @Override
    public INumber div(INumber num) {
        return num.divByFloat(this);
    }

    @Override
    public INumber divByFloat(TFloat num) {
        return new TFloat(num.value / this.value);
    }

    @Override
    public INumber divByInt(TInt num) {
        return new TFloat(Integer.parseInt(num.toString()) / this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TFloat) {
            var o = (TFloat) obj;
                return o.toString().equals(this.toTFloat().toString());
        }
        else {
            return false;
        }
    }
}
