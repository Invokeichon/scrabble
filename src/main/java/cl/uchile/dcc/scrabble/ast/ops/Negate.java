package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.AST;
import cl.uchile.dcc.scrabble.ast.leaves.Constant;

/**
 * Class representing the Negate operation on an AST.
 */
public class Negate implements AST, Operation{
    AST o;

    /**
     * Creates a new Negate instance with the provided node.
     */
    public Negate(AST obj) {
        this.o = obj;
    }

    @Override
    public Constant eval() {
        return o.eval().negate();
    }

}
