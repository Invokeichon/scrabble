package cl.uchile.dcc.scrabble.types;

public class TBinary implements IType, INumber {
    private String value;

    /**
     * Constructor que retorna un objeto TBinary almacenando
     * el valor entregado.
     * @param binary binario a almacenar
     */
    public TBinary (String binary) {
        this.value = binary;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public double toFloat() {
        // se implementa despues
        double placeholder = 0;
        return placeholder;
    }

    /**
     * Retorna el valor almacenado como un binario (string de 0s y 1s)
     * @return binary
     */
    public String toBinary() {
        return this.value;
    }

    // las otras conversiones se omiten en esta entrega parcial

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TBinary) {
            var o = (TBinary) obj;
            return o.toBinary().equals(this.toBinary());
        }
        else {
            return false;
        }
    }

}
