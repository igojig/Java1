package lesson2;

public class Lesson2 {
    public static void main(String[] args) {

        System.out.println(isSumBetween10and20(5, 10));
        System.out.println();

        isPositiveOrNegative(-5);
        System.out.println();

        System.out.println(isNegative(0));
        System.out.println();

        repeatString("test", 5);
        System.out.println();

        System.out.println();
        for (int i = 1800; i < 2200; i++) {
            if (isLeapYear(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isSumBetween10and20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void isPositiveOrNegative(int x) {
        if (x >= 0)
            System.out.println("Positive number");
        else
            System.out.println("Negative number");
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void repeatString(String str, int count) {
        if (count <= 0)
            return;
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        boolean result = false;
        if (year % 4 == 0) {
            result = true;
            if (year % 100 == 0) {
                result = false;
                if (year % 400 == 0) {
                    result = true;
                }
            }
        }
        return result;
    }

}
