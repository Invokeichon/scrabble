package cl.uchile.dcc.scrabble.types;

public interface INonDouble {

    TInt toTInt();
    TBinary toTBinary();

    INonDouble addByBinary(TBinary num);
    INonDouble subByBinary(TBinary num);
    INonDouble multByBinary(TBinary num);
    INonDouble divByBinary(TBinary num);

}
