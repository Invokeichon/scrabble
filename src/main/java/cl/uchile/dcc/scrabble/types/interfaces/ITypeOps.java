package cl.uchile.dcc.scrabble.types.interfaces;

import cl.uchile.dcc.scrabble.types.interfaces.IType;

/**
 * Interface that describes operations between IType objects.
 * Extends from IType.
 */
public interface ITypeOps extends IType {

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" add method
     * of the t Object, that in turn returns the result of the operation.
     * @param t Object that is being added
     * @return Result of the sum
     */
    IType add(IType t);
}
