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
    double toFloat();
}
