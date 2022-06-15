package lesson8.calculator.symbol;

import lesson8.calculator.Expression;

import java.util.function.BiFunction;

public enum Operator implements Symbol {

    PLUS("+", 1, Double::sum),
    MINUS("-", 1, (a, b) -> a - b),
    MULTIPLY("*", 2, (a, b) -> a * b),
    DIVIDE("/", 2, (a, b) -> a / b),
    POW("^", 3, Math::pow),

    EQUALS("=", 0, null) {
        @Override
        public void doAction(Expression expression) {
            expression.doCalculate();
        }
    };

    private final String stringValue;
    private final int priority;
    private final BiFunction<Double, Double, Double> function;


    Operator(String stringValue, int priority, BiFunction<Double, Double, Double> function) {
        this.function = function;
        this.stringValue = stringValue;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

    @Override
    public String getStringFromSymbol() {
        return stringValue;
    }

    @Override
    public void doAction(Expression expression) {
        if(!expression.isEmpty()) {
            expression.setCalculated(false);
            expression.doAddNewSymbol(stringValue);
        }
    }

}
