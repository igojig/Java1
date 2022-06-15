package lesson8.calculator.button;

import lesson8.calculator.symbol.Symbol;

import javax.swing.*;

public class CalculatorButton extends JButton {
    private final Symbol symbol;

    public CalculatorButton(Symbol symbol){
        super(symbol.getStringFromSymbol());
        this.symbol=symbol;
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
