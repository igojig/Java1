package lesson1.homework1;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");
    }

    public static void checkSumSign() {

        final int UPPER_BOUND = 100;
        int a = ThreadLocalRandom.current().nextInt(UPPER_BOUND) - UPPER_BOUND / 2;
        int b = ThreadLocalRandom.current().nextInt(UPPER_BOUND) - UPPER_BOUND / 2;

//        System.out.println(a);
//        System.out.println(b);

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();

    }

    public static void printColor() {

        final int UPPER_BOUND = 1000;
        int value = ThreadLocalRandom.current().nextInt(UPPER_BOUND) - UPPER_BOUND / 2;

//        System.out.println(value);

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        System.out.println();

    }

    public static void compareNumbers() {
        final int UPPER_BOUND = 100;
        int a = ThreadLocalRandom.current().nextInt(UPPER_BOUND);
        int b = ThreadLocalRandom.current().nextInt(UPPER_BOUND);

//        System.out.println(a);
//        System.out.println(b);

        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
        System.out.println();

    }

}
