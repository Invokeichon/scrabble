package cl.uchile.dcc.scrabble.types.interfaces;

import cl.uchile.dcc.scrabble.types.TBinary;
import cl.uchile.dcc.scrabble.types.TInt;

/**
 * Interface that describes methods that all non-float numbers
 * must implement. (TInt, TBinary)
 */
public interface INonDouble extends IType {

    /**
     * Converts the current Scrabble Type into TInt.
     * @return TypeFactory.createInt object
     */
    TInt toTInt();

    /**
     * Converts the current Scrabble Type into TBinary.
     * @return TypeFactory.createBinary object
     */
    TBinary toTBinary();

    /**
     * Double Dispatch implementation.
     * Returns the result of the sum of
     * the TBinary and the object.
     * @param num TBinary that is adding the object
     * @return TBinary + object
     */
    INonDouble addByBinary(TBinary num);

    /**
     * Double Dispatch implementation.
     * Returns the result of the subtraction of
     * the TBinary and the object.
     * @param num TBinary that is subtracting the object
     * @return TBinary - object
     */
    INonDouble subByBinary(TBinary num);

    /**
     * Double Dispatch implementation.
     * Returns the result of the multiplication of
     * the TBinary and the object.
     * @param num TBinary that is multiplying the object
     * @return TBinary * object
     */
    INonDouble multByBinary(TBinary num);

    /**
     * Double Dispatch implementation.
     * Returns the result of the division of
     * the TBinary and the object.
     * @param num TBinary that is dividing the object
     * @return TBinary / object
     */
    INonDouble divByBinary(TBinary num);

}
