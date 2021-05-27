package cl.uchile.dcc.scrabble.types;

public interface ILogic {

    default char boolToBin(boolean b) {
        if (b) { return '1'; }
        else { return '0'; }
    }
    ILogic and(ILogic p);
    ILogic andByBool(TBool b);
    ILogic andByBinary(TBinary b);

    ILogic or(ILogic p);
    ILogic orByBool(TBool b);
    ILogic orByBinary(TBinary b);

    ILogic negate();
}
