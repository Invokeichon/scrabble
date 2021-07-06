package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.AST;
import cl.uchile.dcc.scrabble.ast.leaves.Constant;

/**
 * Interface describing the shared behavior of all Operation classes (AST Operations).
 */
public interface Operation extends AST {

    /**
     * Converts the result of the operation into a CBinary (if possible)
     * if not, returns a null.
     * @return CBinary (or null)
     */
    default Constant toCBinary() {
        Constant e = this.eval();
        if (e == null) {
            return null;
        }
        return e.toCBinary();
    }

    /**
     * Converts the result of the operation into a CString (if possible)
     * if not, returns a null.
     * @return CString (or null)
     */
    default Constant toCString() {
        Constant e = this.eval();
        if (e == null) {
            return null;
        }
        return e.toCString();
    }

    /**
     * Converts the result of the operation into a CInt (if possible)
     * if not, returns a null.
     * @return CInt (or null)
     */
    default Constant toCInt() {
        Constant e = this.eval();
        if (e == null) {
            return null;
        }
        return e.toCInt();
    }

    /**
     * Converts the result of the operation into a CFloat (if possible)
     * if not, returns a null.
     * @return CFloat (or null)
     */
    default Constant toCFloat() {
        Constant e = this.eval();
        if (e == null) {
            return null;
        }
        return e.toCFloat();
    }

    /**
     * Converts the result of the operation into a CBool (if possible)
     * if not, returns a null.
     * @return CBool (or null)
     */
    default Constant toCBool() {
        Constant e = this.eval();
        if (e == null) {
            return null;
        }
        return e.toCBool();
    }
}
