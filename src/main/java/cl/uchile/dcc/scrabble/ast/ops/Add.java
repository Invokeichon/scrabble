package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.Constant;
import cl.uchile.dcc.scrabble.ast.AST;

/**
 * Class representing the Add operation on an AST.
 */
public class Add implements AST, Operation{
    AST l;
    AST r;

    /**
     * Creates a new Add instance with the provided left and right nodes.
     */
    public Add(AST left, AST right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public Constant eval() {
        return l.eval().add(r.eval());
    }

}
