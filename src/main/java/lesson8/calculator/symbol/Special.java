package lesson8.calculator.symbol;

import lesson8.calculator.Expression;

public enum Special implements Symbol {
    CLEAR("C"){
        @Override
        public void doAction(Expression expression) {
            expression.doClear();
        }
    },
    BACK_SPACE("\uD83E\uDC10"){
        @Override
        public void doAction(Expression expression) {
            expression.doBackSpace();
        }
    };

    private final String stringValue;

    Special(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String getStringFromSymbol() {
        return stringValue;
    }
}
