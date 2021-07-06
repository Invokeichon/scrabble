package cl.uchile.dcc.scrabble.types.interfaces;

import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.TString;

/**
 * Interface specifying the methods that ANY Scrabble Type must implement.
 */
public interface IType{

    /**
     * Returns the value stored in the Scrabble Type
     * as a Java String.
     * @return String
     */
    String toString();

    /**
     * Returns a TypeFactory.createString Object that is a
     * transformation of the current Object.
     * @return TypeFactory.createString
     */
    default TString toTString() {
        return TypeFactory.createString(this.toString());
    }

    /**
     * Double Dispatch.
     * Response function of add by a TString object.
     * Returns the result of the addition of both objects
     * as a TypeFactory.createString object.
     * @param str TString Obj that started the addition.
     * @return TypeFactory.createString Obj with the result.
     */
    default TString addedByString (TString str) {
        return TypeFactory.createString(str.toString() + this.toString());
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
