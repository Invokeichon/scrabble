package cl.uchile.dcc.scrabble.types;

/**
 * Interface that describes methods that all types
 * with logical behavior must implement.
 * Operations are integrated into the interface, as they are symmetrical.
 */
public interface ILogic {

    /**
     * Converts a boolean into a binary equivalent.
     * @param b boolean input
     * @return char containing the binary equivalent
     */
    default char boolToBin(boolean b) {
        if (b) { return '1'; }
        else { return '0'; }
    }

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" (and) method
     * of the p Object, that in turn returns the result of the operation
     * stored in an ILogic object.
     * @param p Object that is being operated
     * @return Result of the operation
     */
    ILogic and(ILogic p);

    /**
     * Double Dispatch.
     * Response function to an (and) operation by a TBool.
     * Returns the result of the operation of both objects
     * as a new ILogic object.
     * @param b TBool Obj that started the logical operation.
     * @return new ILogic object with the result.
     */
    ILogic andByBool(TBool b);

    /**
     * Double Dispatch.
     * Response function to an (and) operation by a TBinary.
     * Returns the result of the operation of both objects
     * as a new ILogic object.
     * @param b TBinary Obj that started the logical operation.
     * @return new ILogic object with the result.
     */
    ILogic andByBinary(TBinary b);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" (or) method
     * of the p Object, that in turn returns the result of the operation
     * stored in an ILogic object.
     * @param p Object that is being operated
     * @return Result of the sum
     */
    ILogic or(ILogic p);

    /**
     * Double Dispatch.
     * Response function to an (or) operation by a TBool.
     * Returns the result of the addition of both objects
     * as a new ILogic object.
     * @param b TBool Obj that started the logical operation.
     * @return new ILogic object with the result.
     */
    ILogic orByBool(TBool b);

    /**
     * Double Dispatch.
     * Response function to an (or) operation by a TBinary.
     * Returns the result of the operation of both objects
     * as a new ILogic object.
     * @param b TBinary Obj that started the logical operation.
     * @return new ILogic object with the result.
     */
    ILogic orByBinary(TBinary b);

    /**
     * Returns a new ILogic object containing the logical
     * negation of the calling object.
     * @return new ILogic object
     */
    ILogic negate();
}
