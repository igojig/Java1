package lesson3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson3 {
    public static void main(String[] args) {

//      задание 1
        invertArray();
        System.out.println();

//      задание 2
        fillArray();
        System.out.println();

//      задание 3
        changeArray();
        System.out.println();

//      задание 4
        fillDiagonal();
        System.out.println();

//      задание 5
        System.out.println(Arrays.toString(getArray(3, 5)));
        System.out.println();

//        задание 6
        findMinAndMax();
        System.out.println();

//      задание 7
//        int[] arr={1,1,1,1,0, 4};
        int[] arr = {2, 1, 7, 1, 7, 2};
//        int[] arr = {1,1,1,2,1};
//      int [] arr={2, 0, 0};
        boolean res = isLeftEqualsRight(arr);
        System.out.println(res);
        System.out.println();

//        задание 8
        int[] dim = {1, 2, 3, 4, 5};
//        int[] dim={3,5,6,1};
        shiftArray(dim, 2);


    }


    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        final int LENGTH = 5;
        int[][] arr = new int[LENGTH][LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            arr[i][i] = 1;
            arr[i][arr[i].length - i - 1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[] getArray(int len, int initialValue) {

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void findMinAndMax() {
        final int LENGTH = 10;
        final int UPPER_BOUND = 100;
        int[] arr = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(UPPER_BOUND);
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < LENGTH; i++) {
            if (min > arr[i])
                min = arr[i];
            if (max < arr[i])
                max = arr[i];
        }

        System.out.println("Source array: " + Arrays.toString(arr));
        System.out.println("Min element is: " + min);
        System.out.println("Max element is: " + max);

    }

    public static boolean isLeftEqualsRight(int[] source) {
        // считаем, что массив из одного элемента не имеет правых и левых частей
        if (source.length < 2)
            return false;

        int leftIndex = -1;
        int rightIndex = source.length;

        int leftSum = 0;
        int rightSum = 0;

        while (leftIndex < rightIndex) {


            // предотвращение зацикливания если суммы слева и справа равны, а массив не пройден до конца
            // идем дальше по одной из сторон
            if (leftSum <= rightSum)
                leftSum += source[++leftIndex];
            else
                rightSum += source[--rightIndex];

            if (leftSum == rightSum && (rightIndex - leftIndex) == 1) {

                return true;
            }
        }
        return false;
    }


    public static void shiftArray(int[] source, int step) {

        // избегаем переполнения
        step %= source.length;

        // сдвиг влево это сдвиг вправо с другим шагом
        if (step < 0) {
            step += source.length;
        }
        for (int i = 0; i < step; i++) {
            int temp = source[source.length - 1];
            for (int j = source.length - 1; j > 0; j--) {
                source[j] = source[j - 1];
            }
            source[0] = temp;
        }
        System.out.println(Arrays.toString(source));
    }

}


