package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.interfaces.INumber;
import cl.uchile.dcc.scrabble.types.interfaces.INumberOps;
import cl.uchile.dcc.scrabble.types.interfaces.IType;

import java.util.Objects;

/**
 * Class that represents a Scrabble Float. Stores a Java double.
 */
public class TFloat implements IType, INumberOps {
    private double value;

    /**
     * Constructs a TypeFactory.createFloat object containing the
     * double provided.
     * @param arg double to be stored in the object.
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
        return TypeFactory.createFloat(this.value);
    }

    @Override
    public INumber add(INumber num) {
        return num.addByFloat(this);
    }

    @Override
    public INumber addByFloat(TFloat num) {
        return TypeFactory.createFloat(num.value + this.value);
    }

    @Override
    public INumber addByInt(TInt num) {
        return TypeFactory.createFloat(Integer.parseInt(num.toString()) + this.value);
    }

    @Override
    public INumber sub(INumber num) {
        return num.subByFloat(this);
    }

    @Override
    public INumber subByFloat(TFloat num) {
        return TypeFactory.createFloat(num.value - this.value);
    }

    @Override
    public INumber subByInt(TInt num) {
        return TypeFactory.createFloat(Integer.parseInt(num.toString()) - this.value);
    }

    @Override
    public INumber mult(INumber num) {
        return num.multByFloat(this);
    }

    @Override
    public INumber multByFloat(TFloat num) {
        return TypeFactory.createFloat(num.value * this.value);
    }

    @Override
    public INumber multByInt(TInt num) {
        return TypeFactory.createFloat(Integer.parseInt(num.toString()) * this.value);
    }

    @Override
    public INumber div(INumber num) {
        return num.divByFloat(this);
    }

    @Override
    public INumber divByFloat(TFloat num) {
        return TypeFactory.createFloat(num.value / this.value);
    }

    @Override
    public INumber divByInt(TInt num) {
        return TypeFactory.createFloat(Integer.parseInt(num.toString()) / this.value);
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

    @Override
    public int hashCode() {
        return Objects.hash(TFloat.class, this.value);
    }
}
