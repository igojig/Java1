package lesson8.calculator;

import lesson8.calculator.button.CalculatorButton;
import lesson8.calculator.symbol.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm extends JFrame {

    final int DIMENSION_X = 400;
    final int DIMENSION_Y = 400;

    Expression expression;

    public MyForm(String title) {
        super(title);

        createMainFrame();

        JPanel panelInput = createInputPanel();
        JPanel panelOperators = createOperatorPanel();
        JPanel panelDigits = createDigitPanel();

        add(panelInput, BorderLayout.NORTH);
        add(panelOperators, BorderLayout.WEST);
        add(panelDigits, BorderLayout.CENTER);
//        pack();
        setVisible(true);

    }

    private JPanel createDigitPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 3, 3));

        Symbol[][] symbols = {
                {Digit.ONE, Digit.TWO, Digit.THREE},
                {Digit.FOUR, Digit.FIVE, Digit.SIX},
                {Digit.SEVEN, Digit.EIGHT, Digit.NINE},
                {Digit.DOT, Digit.ZERO, Operator.EQUALS},
        };


        for (Symbol[] row : symbols) {
            for (Symbol col : row) {
                JButton button = new CalculatorButton(col);
                button.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        expression.enterNewSymbol(((CalculatorButton) e.getSource()).getSymbol());
                        ((CalculatorButton) e.getSource()).getSymbol().doAction(expression);
                        expression.show();
                    }
                });
                panel.add(button);
            }
        }

        return panel;
    }

    private JPanel createOperatorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 3, 3));

        Symbol[] symbols = {
                Operator.PLUS,
                Operator.MINUS,
                Operator.MULTIPLY,
                Operator.DIVIDE,
                Bracket.OPEN_BRACKET,
                Bracket.CLOSE_BRACKET,
                Special.BACK_SPACE,
                Operator.POW,
                Special.CLEAR
        };

        for (Symbol symbol : symbols) {
            JButton button = new CalculatorButton(symbol);
            button.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            button.addActionListener(e -> {
//                    expression.enterNewSymbol(((CalculatorButton) e.getSource()).getSymbol());
                ((CalculatorButton) e.getSource()).getSymbol().doAction(expression);
                expression.show();
            });
            panel.add(button);
        }

        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        textField.setBackground(new Color(169, 191, 253));
        textField.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
        panel.add(textField);

        expression = new Expression(textField);

        return panel;
    }

    private void createMainFrame() {
        setSize(DIMENSION_X, DIMENSION_Y);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
    }

}
