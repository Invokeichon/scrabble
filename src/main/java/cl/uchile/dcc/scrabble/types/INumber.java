package cl.uchile.dcc.scrabble.types;

/**
 * Interfaz que especifica que metodos *debe* implementar un
 * Scrabble number type (TInt, TFloat, TBinary)
 * que NO se haya descrito ya en IType
 */

public interface INumber {
    /**
     * Transforma el valor contenido a un Float
     * @return Float
     */
    TFloat toTFloat();

    INumber add(INumber num);
    INumber addByFloat(TFloat num);
    INumber addByInt(TInt num);

    INumber sub(INumber num);
    INumber subByFloat(TFloat num);
    INumber subByInt(TInt num);

    INumber mult(INumber num);
    INumber multByFloat(TFloat num);
    INumber multByInt(TInt num);

    INumber div(INumber num);
    INumber divByFloat(TFloat num);
    INumber divByInt(TInt num);

}
