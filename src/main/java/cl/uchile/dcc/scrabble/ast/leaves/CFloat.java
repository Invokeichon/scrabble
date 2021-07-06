package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.TFloat;
import cl.uchile.dcc.scrabble.types.interfaces.IType;

/**
 * Constant Float class.
 * Adapts a TFloat obj giving it AST functionalities.
 */
public class CFloat extends AbsCNumber {

    /**
     * Instances a CFloat.
     * Creates a TFloat that contains the double given,
     * and adapts it to CFloat.
     */
    public CFloat(double f) {
        super(TypeFactory.createFloat(f));
    }

    /**
     * Instances a CFloat that stores the TFloat given.
     * Intended for use in operation methods, otherwise
     * the other constructor is recommended.
     */
    public CFloat(TFloat f) { super(f);}

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public CFloat toCFloat() {
        return this;
    }
}
