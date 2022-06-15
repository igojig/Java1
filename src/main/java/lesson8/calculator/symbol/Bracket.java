package lesson8.calculator.symbol;

import lesson8.calculator.Expression;

public enum Bracket implements Symbol{
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")");

    private final String stringValue;

    Bracket(String stringValue) {
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
