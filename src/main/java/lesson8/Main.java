package lesson8;

import lesson8.calculator.MyForm;

public class Main {

    public static void abc(int a, double b){
        System.out.println(1);
    }

    public static void abc(double a, int b){
        System.out.println(2);
    }

    public static void main(String[] args) {
        abc(1.,1);
        new MyForm("Calculator");
    }
}
