package cl.uchile.dcc.scrabble.types;

/**
 * Interface specifying the methods that ANY Scrabble Type must implement.
 */
public interface IType {

    /**
     * Returns the value stored in the Scrabble Type
     * as a Java String.
     * @return String
     */
    String toString();

    /**
     * Returns a new TString Object that is a
     * transformation of the current Object.
     * @return new TString
     */
    default TString toTString() {
        return new TString(this.toString());
    }

    /**
     * Double Dispatch.
     * Response function of add by a TString object.
     * Returns the result of the addition of both objects
     * as a new TString object.
     * @param str TString Obj that started the addition.
     * @return new TString Obj with the result.
     */
    default TString addedByString (TString str) {
        return new TString(str.toString() + this.toString());
    }
    /**
     * Checks if the objects are equal, through class instance and value.
     * @return boolean
     */
    boolean equals(Object o);

    /**
     * Generates a hashcode of the object using its Class and value stored.
     * @return hashcode
     */
    int hashCode();
}
