package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.types.TBinary;
import cl.uchile.dcc.scrabble.types.TBool;
import cl.uchile.dcc.scrabble.types.interfaces.ILogic;

/**
 * Constant abstract class for Logic types (TBinary, TBool),
 * offers operation methods for Constant Float and Constant Int.
 */
public abstract class AbsCLogic implements Constant {
    protected ILogic type;

    public AbsCLogic(ILogic o) {
        type = o;
    }

    @Override
    public Constant or(Constant addend) {
        try {
            type = type.or((ILogic) addend.getType());
            try {
                return new CBool((TBool) type);
            } catch (ClassCastException e) {
                return new CBinary((TBinary) type);
            }
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public Constant and(Constant addend) {
        try {
            type = type.and((ILogic) addend.getType());
            try {
                return new CBool((TBool) type);
            } catch (ClassCastException e) {
                return new CBinary((TBinary) type);
            }
        } catch (ClassCastException e) {
            return null;
        }
    }
}
