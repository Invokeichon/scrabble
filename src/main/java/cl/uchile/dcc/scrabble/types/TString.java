package cl.uchile.dcc.scrabble.types;

public class TString implements IType{
    private String value;

    /**
     * Retorna un Objeto TString que contiene
     * el valor entregado.
     * @param str String a almacenar
     */
    public TString (String str) {
        this.value = str;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TString) {
            var o = (TString) obj;
            return o.toString().equals(this.toString());
        }
        else {
            return false;
        }
    }
}
