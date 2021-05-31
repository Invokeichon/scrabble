package cl.uchile.dcc.scrabble.types;

/**
 * Interface that describes operations between INumber types.
 * Extends from INumber.
 */
public interface INumberOps extends INumber{

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" add method
     * of the num Object, that in turn returns the result of the operation
     * stored in an INumber object.
     * @param num Object that is being added
     * @return Result of the sum
     */
    INumber add(INumber num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" sub method
     * of the num Object, that in turn returns the result of the operation
     * stored in an INumber object.
     * @param num Object that is being subtracted
     * @return Result of the subtraction
     */
    INumber sub(INumber num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" mult method
     * of the num Object, that in turn returns the result of the operation
     * stored in an INumber object.
     * @param num Object that is being multiplied
     * @return Result of the multiplication
     */
    INumber mult(INumber num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" div method
     * of the num Object, that in turn returns the result of the operation.
     * stored in an INumber object.
     * @param num Object that is being divided
     * @return Result of the division
     */
    INumber div(INumber num);

}
