package cl.uchile.dcc.scrabble.types;

/**
 * Interface that describes operations compatible with INonDouble types.
 * Extends from INonDouble.
 */

public interface INonDoubleOps extends INonDouble{

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" add method
     * of the num Object, that in turn returns the result of the operation.
     * @param num Object that is being added
     * @return Result of the sum
     */
    INonDouble add(INonDouble num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" sub method
     * of the num Object, that in turn returns the result of the operation.
     * @param num Object that is being subtracted
     * @return Result of the subtraction
     */
    INonDouble sub(INonDouble num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" mult method
     * of the num Object, that in turn returns the result of the operation.
     * @param num Object that is being multiplied
     * @return Result of the multiplication
     */
    INonDouble mult(INonDouble num);

    /**
     * Double Dispatch implementation.
     * Calls the corresponding "response" div method
     * of the num Object, that in turn returns the result of the operation.
     * @param num Object that is being divided
     * @return Result of the division
     */
    INonDouble div(INonDouble num);
}
