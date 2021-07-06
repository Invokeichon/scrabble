package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.interfaces.ILogic;
import cl.uchile.dcc.scrabble.types.interfaces.INonDouble;
import cl.uchile.dcc.scrabble.types.interfaces.IType;
import cl.uchile.dcc.scrabble.types.TBinary;

/**
 * Constant Binary class.
 * Adapts a TBinary obj giving it AST functionalities.
 */
public class CBinary implements Constant {
    protected TBinary type;

    /**
     * Instances a CBinary.
     * Creates a TBinary that contains the string given,
     * and adapts it to CBinary.
     */
    public CBinary(String bin) {
        type = TypeFactory.createBinary(bin);
    }

    /**
     * Instances a CBinary that stores the TBinary given.
     * Intended for use in operation methods, otherwise
     * the other constructor is recommended.
     */
    public CBinary(TBinary bin) {
        type = bin;
    }

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public Constant add(Constant addend) {
        try {
            type = (TBinary) type.add((INonDouble) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant sub(Constant addend) {
        try {
            type = (TBinary) type.sub((INonDouble) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant mult(Constant addend) {
        try {
            type = (TBinary) type.mult((INonDouble) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant div(Constant addend) {
        try {
            type = (TBinary) type.div((INonDouble) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant or(Constant addend) {
        try {
            type = (TBinary) type.or((ILogic) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant and(Constant addend) {
        try {
            type = (TBinary) type.and((ILogic) addend.getType());
            return this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant negate() {
        type = type.negate();
        return this;
    }

    @Override
    public CFloat toCFloat() {
        return new CFloat(type.toTFloat());
    }

    @Override
    public CInt toCInt() {
        return new CInt(type.toTInt());
    }

    @Override
    public CBinary toCBinary() {
        return this;
    }

}
