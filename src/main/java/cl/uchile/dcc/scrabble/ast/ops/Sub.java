package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the Sub operation on an AST.
 */
public class Sub implements AST, Operation {
    AST l;
    AST r;

    /**
     * Creates a new Sub instance with the provided left and right nodes.
     */
    public Sub(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().sub(r.eval());
    }

}
