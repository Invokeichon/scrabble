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

    default TString toTString() {
        return new TString(this.toString());
    }

    default TString addedByString (TString str) {
        return new TString(str.toString() + this.toString());
    }
    /**
     * Chequea si los objetos son iguales.
     * @return son iguales?
     */
    boolean equals(Object o);
}
