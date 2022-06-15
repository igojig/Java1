package lesson8.calculator.symbol;

import lesson8.calculator.Expression;

public interface Symbol {
     String getStringFromSymbol();

     void doAction(Expression expression);
}
