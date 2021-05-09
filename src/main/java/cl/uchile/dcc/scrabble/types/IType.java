package cl.uchile.dcc.scrabble.types;

/**
 * Interfaz que especifica que metodos *debe* implementar un Scrabble Type.
 */
public interface IType {

    /**
     * Entrega el valor almacenado en el tipo de Scrabble
     * como un String de Java
     * @return String
     */
    String toString();

    /**
     * Checkea si los objetos son iguales.
     * @return son iguales?
     */
    boolean equals(Object o);
}
