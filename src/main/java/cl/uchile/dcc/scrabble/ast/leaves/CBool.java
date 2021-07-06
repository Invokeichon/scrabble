package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.TBool;
import cl.uchile.dcc.scrabble.types.interfaces.IType;

/**
 * Constant Bool class.
 * Adapts a TBool obj giving it AST functionalities.
 */
public class CBool extends AbsCLogic {

    /**
     * Instances a CBool.
     * Creates a TBool that contains the boolean given,
     * and adapts it to CBool.
     */
    public CBool(boolean b) {
        super(TypeFactory.createBool(b));
    }

    /**
     * Instances a CBool that stores the TBool given.
     * Intended for use in operation methods, otherwise
     * the other constructor is recommended.
     */
    public CBool(TBool b) {
        super(b);
    }

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public CBool toCBool(){
        return this;
    }

    @Override
    public Constant negate(){
        return new CBool((TBool) type.negate());
    }
}
