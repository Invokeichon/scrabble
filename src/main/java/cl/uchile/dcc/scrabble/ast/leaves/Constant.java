package cl.uchile.dcc.scrabble.ast.leaves;

import cl.uchile.dcc.scrabble.ast.AST;
import cl.uchile.dcc.scrabble.types.interfaces.IType;

/**
 * Interface describing the functionalities all Constants must implement.
 */
public interface Constant extends AST {

    /**
     * returns the IType stored in the constant.
     * @return IType obj
     */
    IType getType();

    /**
     * Method called by Add.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant add(Constant addend) {
        return null;
    }

    /**
     * Method called by Sub.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant sub(Constant addend) {
        return null;
    }

    /**
     * Method called by Mult.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant mult(Constant addend) {
        return null;
    }

    /**
     * Method called by Div.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant div(Constant addend) {
        return null;
    }

    /**
     * Method called by And.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant and(Constant addend) {
        return null;
    }

    /**
     * Method called by Or.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant or(Constant addend) {
        return null;
    }

    /**
     * Method called by Negate.
     * Evaluates the operation, returning the corresponding Constant of the result,
     * or if the operation is invalid, returns null.
     */
    default Constant negate() {
        return null;
    }

    /**
     * Converts the current Constant into a Binary Constant,
     * storing a TBinary obj.
     * If the transformation is invalid, null is returned.
     * @return CBinary obj
     */
    default CBinary toCBinary() {
        return null;
    }

    /**
     * Converts the current Constant into a Bool Constant,
     * storing a TBool obj.
     * If the transformation is invalid, null is returned.
     * @return CBool obj
     */
    default CBool toCBool() {
        return null;
    }

    /**
     * Converts the current Constant into a Float Constant,
     * storing a TFloat obj.
     * If the transformation is invalid, null is returned.
     * @return CFloat obj
     */
    default CFloat toCFloat() {
        return null;
    }

    /**
     * Converts the current Constant into a Int Constant,
     * storing a TInt obj.
     * If the transformation is invalid, null is returned.
     * @return CInt obj
     */
    default CInt toCInt() {
        return null;
    }

    /**
     * Converts the current Constant into a String Constant,
     * storing a TString obj.
     * If the transformation is invalid, null is returned.
     * @return CString obj
     */
    default CString toCString() {
        return new CString(this.getType().toTString());
    }

    @Override
    default Constant eval(){
        return this;
    }
}
