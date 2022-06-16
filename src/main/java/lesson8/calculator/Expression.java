package lesson8.calculator;

import lesson8.calculator.symbol.Symbol;
import lesson8.calculator.math_engine.MathEngine;


import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class Expression {

    private final JTextField textField;

    private boolean isCalculated = false;

    private final StringBuilder expressionString = new StringBuilder("");

    public Expression(JTextField textField) {
        this.textField = textField;
        doClear();
        show();
    }


    public void enterNewSymbol(Symbol symbol) {
        evaluateNewExpression(symbol);
        show();
    }


    private void evaluateNewExpression(Symbol symbol) {
        symbol.doAction(this);
    }

    public void show() {
        textField.setText(expressionString.toString());
    }

    public void doAddNewSymbol(String s) {
        expressionString.append(s);
    }

    public void doCalculate() {
        if (!isEmpty()) {
            try {

                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');

                DecimalFormat decimalFormat = new DecimalFormat("#.###");
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

                String stringPostfix = MathEngine.toPostfixFromInfix((expressionString.toString()));
                Double result = MathEngine.postfixToDouble(stringPostfix);

                expressionString.setLength(0);
                expressionString.append(decimalFormat.format(result));

            } catch (RuntimeException e) {
                expressionString.setLength(0);
                expressionString.append("ERROR");
                System.out.println(e);
            } finally {
                isCalculated = true;
            }
        }
    }

    public void doBackSpace() {
        if (!isEmpty()) {
            expressionString.deleteCharAt(expressionString.length() - 1);
        }
    }

    public void doClear() {
        isCalculated = false;
        expressionString.setLength(0);
    }

    public boolean isEmpty() {
        return expressionString.isEmpty();
    }

    public boolean isCalculated() {
        return isCalculated;
    }

    public void setCalculated(boolean value) {
        isCalculated = value;
    }


}
