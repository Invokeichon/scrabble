package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;

/**
 * Interface describing the basic functionality of any AST component.
 */
public interface AST {
    /**
     * Evaluates the operation/constant.
     * If a constant, returns itself.
     * For operations, the operation is executed, and for invalid cases a null is given.
     * @return AST constant
     */
    Constant eval();
}
