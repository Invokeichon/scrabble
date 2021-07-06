package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the Div operation on an AST.
 */
public class Div implements AST, Operation {
    AST l;
    AST r;

    /**
     * Creates a new Div instance with the provided left and right nodes.
     */
    public Div(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().div(r.eval());
    }

}
