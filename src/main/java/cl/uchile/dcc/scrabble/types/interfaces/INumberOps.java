package cl.uchile.dcc.scrabble.types.interfaces;

import cl.uchile.dcc.scrabble.types.interfaces.INumber;

/**
 * Interface that describes operations between INumber types.
 * Extends from INumber.
 */
public interface INumberOps extends INumber {

    INumber add(INumber num);

    INumber sub(INumber num);

    INumber mult(INumber num);

    INumber div(INumber num);

}
