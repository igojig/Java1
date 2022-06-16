package lesson8.calculator.math_engine;


import lesson8.calculator.symbol.Operator;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathEngine {
    private static final ArrayDeque<String> stackString = new ArrayDeque<>();
    private static final StringBuilder resultString = new StringBuilder();
    private final static ArrayDeque<Double> stackDouble = new ArrayDeque<>();

    private final static Map<String, Integer> operatorPriority = new HashMap<>();
    private final static Map<String, BiFunction<Double, Double, Double>> operatorFunction = new HashMap<>();

    static {
        for (Operator op : Operator.values()) {
            operatorPriority.put(op.getStringFromSymbol(), op.getPriority());
            operatorFunction.put(op.getStringFromSymbol(), op.getFunction());
        }

//        operatorPriority.put("+", 1);
//        operatorPriority.put("-", 1);
//        operatorPriority.put("*", 2);
//        operatorPriority.put("/", 2);
//        operatorPriority.put("^", 3);
    }

    public static double postfixToDouble(String strPostfix) {
        stackDouble.clear();

        String[] arrPostfix = strPostfix.split("\s");

        for (String mathExpression : arrPostfix) {
            if (isNumeric(mathExpression)) {
                stackDouble.push(Double.parseDouble(mathExpression));
            } else if (isOperator(mathExpression)) {
                double oper2 = stackDouble.pop();
                double oper1 = stackDouble.pop();
                double result = calculate(oper1, oper2, mathExpression);
                stackDouble.push(result);
            } else {
                throw new RuntimeException("Error in postfixToDouble function");
            }
        }
        return stackDouble.pop();
    }

    private static double calculate(double operand_1, double operand_2, String operator) {

        var function = operatorFunction.get(operator);
        if (function == null) {
            throw new RuntimeException("Error in calculate function");
        }

        return function.apply(operand_1, operand_2);

//        return switch (operator) {
//            case "+" -> operand_1 + operand_2;
//            case "-" -> operand_1 -operand_2;
//            case "*" -> operand_1 * operand_2;
//            case "/" -> operand_1 / operand_2;
//            case "^" -> Math.pow(operand_1, operand_2);
//            default -> {
//                System.out.println("ЧТо то не так...");
//                throw new RuntimeException("Что то не так...");
//            }
//        };
    }

    public static String toPostfixFromInfix(String strMathInfix) {
        stackString.clear();
        resultString.setLength(0);
        Matcher matcher = getMatcher(strMathInfix);
        while (matcher.find()) {
            String mathElement = matcher.group();
            if (isNumeric(mathElement)) {
                addToString(mathElement);
            } else if (isOperator(mathElement)) {
                doOperator(mathElement);
            } else if (mathElement.equals("(")) {
                stackString.push(mathElement);
            } else if (mathElement.equals(")")) {
                doBracket();
            } else {
                throw new RuntimeException("Error in toPostfixfromInfix function");
            }
        }
        while (!stackString.isEmpty()) {
            resultString.append(stackString.pop()).append(" ");
        }
        return resultString.toString();
    }

    static void doBracket() {
        while (!stackString.isEmpty()) {
            String op = stackString.pop();
            if (op.equals("("))
                break;
            else {
                resultString.append(op).append(" ");
            }
        }
    }

    static void doOperator(String opThis) {
        while (!stackString.isEmpty()) {
            String opTop = stackString.pop();
            if (opTop.equals("(")) {
                stackString.push(opTop);
                break;
            } else {
                boolean priority = getPriority(opTop, opThis);
                if (priority) {
                    stackString.push(opTop);
                    break;
                } else {
                    resultString.append(opTop).append(" ");
                }
            }
        }
        stackString.push(opThis);
    }

    static void addToString(String mathElement) {
        resultString.append(mathElement).append(" ");
    }

    static boolean getPriority(String opTop, String opThis) {
        int prTop = operatorPriority.get(opTop);
        int prThis = operatorPriority.get(opThis);
        return prTop < prThis;
    }

    static String getPatternForDigits() {
        return "(\\d+(\\.\\d*)?)";
    }

    static String getPatternForBrackets() {
        return "([\\(\\)])";
    }

    static String getPatternForOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operatorPriority.keySet()) {
            sb.append("\\").append(operator);
        }
        return sb.append("])").toString();
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile(getPatternForDigits());
        return pattern.matcher(str).find();
    }

    public static boolean isOperator(String str) {
        Pattern pattern = Pattern.compile(getPatternForOperators());
        return pattern.matcher(str).find();
    }

    public static String getFullPatternString() {
        return getPatternForDigits() + "|" + getPatternForBrackets() + "|" + getPatternForOperators();
    }

    private static Matcher getMatcher(String strMathInfix) {
        Pattern pattern = Pattern.compile(getFullPatternString());
        return pattern.matcher(strMathInfix);
    }
}
