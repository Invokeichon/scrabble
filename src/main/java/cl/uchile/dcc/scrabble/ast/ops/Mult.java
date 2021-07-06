package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the Mult operation on an AST.
 */
public class Mult implements AST, Operation {
    AST l;
    AST r;

    /**
     * Creates a new Mult instance with the provided left and right nodes.
     */
    public Mult(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().mult(r.eval());
    }

}

