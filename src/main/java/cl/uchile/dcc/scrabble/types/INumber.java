package cl.uchile.dcc.scrabble.types;

/**
 * Interface specifying methods exclusive to Scrabble Number types
 * that must be implemented.
 */

public interface INumber {

    /**
     * Converts the current Scrabble Type into TFloat.
     * @return new TFloat object
     */
    TFloat toTFloat();

    /**
     * Double Dispatch.
     * Response function of add by a TFloat object.
     * Returns the result of the addition of both objects
     * as a new INumber object.
     * @param num TFloat Obj that started the addition.
     * @return new INumber object with the result.
     */
    INumber addByFloat(TFloat num);

    /**
     * Double Dispatch.
     * Response function of add by a TInt object.
     * Returns the result of the addition of both objects
     * as a new INumber object.
     * @param num TInt Obj that started the addition.
     * @return new INumber object with the result.
     */
    INumber addByInt(TInt num);

    /**
     * Double Dispatch.
     * Response function of sub by a TFloat object.
     * Returns the result of the subtraction of both objects
     * as a new INumber object.
     * @param num TFloat Obj that started the subtraction.
     * @return new INumber object with the result.
     */
    INumber subByFloat(TFloat num);

    /**
     * Double Dispatch.
     * Response function of sub by a TInt object.
     * Returns the result of the subtraction of both objects
     * as a new INumber object.
     * @param num TInt Obj that started the subtraction.
     * @return new INumber object with the result.
     */
    INumber subByInt(TInt num);


    /**
     * Double Dispatch.
     * Response function of mult by a TFloat object.
     * Returns the result of the multiplication of both objects
     * as a new INumber object.
     * @param num TFloat Obj that started the multiplication.
     * @return new INumber object with the result.
     */
    INumber multByFloat(TFloat num);

    /**
     * Double Dispatch.
     * Response function of mult by a TInt object.
     * Returns the result of the multiplication of both objects
     * as a new INumber object.
     * @param num TInt Obj that started the multiplication.
     * @return new INumber object with the result.
     */
    INumber multByInt(TInt num);

    /**
     * Double Dispatch.
     * Response function of div by a TFloat object.
     * Returns the result of the division of both objects
     * as a new INumber object.
     * @param num TFloat Obj that started the division.
     * @return new INumber object with the result.
     */
    INumber divByFloat(TFloat num);

    /**
     * Double Dispatch.
     * Response function of div by a TInt object.
     * Returns the result of the division of both objects
     * as a new INumber object.
     * @param num TInt Obj that started the division.
     * @return new INumber object with the result.
     */
    INumber divByInt(TInt num);

}
