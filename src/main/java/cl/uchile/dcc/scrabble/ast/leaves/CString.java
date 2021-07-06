package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.interfaces.IType;
import cl.uchile.dcc.scrabble.types.TString;

/**
 * Constant String class.
 * Adapts a TString obj giving it AST functionalities.
 */
public class CString implements Constant{
    protected TString type;

    /**
     * Instances a CString.
     * Creates a TString that contains the string given,
     * and adapts it to CString.
     */
    public CString(String str) {
        type = TypeFactory.createString(str);
    }

    /**
     * Instances a CString that stores the TString given.
     * Intended for use in operation methods, otherwise
     * the other constructor is recommended.
     */
    public CString(TString str) {
        type = str;
    }

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public Constant add(Constant addend) {
        type = type.add(addend.getType());
        return this;
    }

    @Override
    public CString toCString() {
        return this;
    }

}
