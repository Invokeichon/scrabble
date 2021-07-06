package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the And operation on an AST.
 */
public class And implements AST, Operation {
    AST l;
    AST r;

    /**
     * Creates a new And instance with the provided left and right nodes.
     */
    public And(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().and(r.eval());
    }

}
