package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.TInt;
import cl.uchile.dcc.scrabble.types.interfaces.IType;

/**
 * Constant Int class.
 * Adapts a TInt obj giving it AST functionalities.
 */
public class CInt extends AbsCNumber {

    /**
     * Instances a CInt.
     * Creates a TInt that contains the int given,
     * and adapts it to CInt.
     */
    public CInt(int i) {
        super(TypeFactory.createInt(i));
    }

    /**
     * Instances a CInt that stores the TInt given.
     * Intended for use in operation methods, otherwise
     * the other constructor is recommended.
     */
    public CInt(TInt i) {
        super(i);
    }

    @Override
    public CFloat toCFloat() {
        return new CFloat(type.toTFloat());
    }

    @Override
    public CInt toCInt() {
        return this;
    }

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public CBinary toCBinary() {
        TInt type2 = (TInt) type;
        return new CBinary(type2.toTBinary());
    }

}