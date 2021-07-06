package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the Or operation on an AST.
 */
public class Or implements AST, Operation {
    AST l;
    AST r;

    /**
     * Creates a new Or instance with the provided left and right nodes.
     */
    public Or(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().or(r.eval());
    }

}

