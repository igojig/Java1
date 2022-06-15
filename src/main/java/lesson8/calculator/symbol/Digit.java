package lesson8.calculator.symbol;


import lesson8.calculator.Expression;

public enum Digit implements Symbol {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    DOT(".");

    private final String stringValue;

    Digit(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String getStringFromSymbol() {
        return stringValue;
    }

    @Override
    public void doAction(Expression expression) {
        if(expression.isCalculated()){
            expression.doClear();
            expression.setCalculated(false);
        }
        expression.doAddNewSymbol(stringValue);

    }

}
