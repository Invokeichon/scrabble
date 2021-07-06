package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.types.TFloat;
import cl.uchile.dcc.scrabble.types.TInt;
import cl.uchile.dcc.scrabble.types.interfaces.INumber;
import cl.uchile.dcc.scrabble.types.interfaces.INumberOps;

/**
 * Constant abstract class for NumberOps types (TFloat, TInt),
 * offers operation methods for Constant Float and Constant Int.
 */
public abstract class AbsCNumber implements Constant {
    public INumberOps type;

    public AbsCNumber(INumberOps o) {
        type = o;
    }

    @Override
    public Constant add(Constant addend) {
        try {
            type = (INumberOps) type.add((INumber) addend.getType());
            try {
                return new CFloat((TFloat) type);
            } catch (ClassCastException e) {
                return new CInt((TInt) type);
            }

        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant sub(Constant addend) {
        try {
            type = (INumberOps) type.sub((INumber) addend.getType());
            try {
                return new CFloat((TFloat) type);
            } catch (ClassCastException e) {
                return new CInt((TInt) type);
            }
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant mult(Constant addend) {
        try {
            type = (INumberOps) type.mult((INumber) addend.getType());
            try {
                return new CFloat((TFloat) type);
            } catch (ClassCastException e) {
                return new CInt((TInt) type);
            }
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant div(Constant addend) {
        try {
            type = (INumberOps) type.div((INumber) addend.getType());
            try {
                return new CFloat((TFloat) type);
            } catch (ClassCastException e) {
                return new CInt((TInt) type);
            }
        } catch (ClassCastException e) {
            return null;
        }
    }
}
