package lesson4;

import java.util.Random;
import java.util.Scanner;

public class CrossZero {

    final static int SIZE = 15;
    // длина для выигрыша
    final static int WINNING_LENGTH = 5;

    static int lastColumn;
    static int lastRow;

    static char[][] field;

    final static char DOT_EMPTY = '•';
    final static char DOT_HUMAN = 'X';
    final static char DOT_AI = 'O';

    final static String HEADER_FIRST_SYMBOL = "•";
    final static String SPACE_SYMBOL = " ";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    static int turnCount = 0;
    // для подсчета выигрышной длины
    static int winnerCount = 0;

    public static void main(String[] args) throws InterruptedException {
        initField();
        showField();
        while (true) {
            humanTurn();
//            aiTurn_2();
            showField();
            if (isGameEnd(DOT_HUMAN)) {
                break;
            }
//            Thread.sleep(1000);
            aiTurn();
            showField();
            if (isGameEnd(DOT_AI)) {
                break;
            }
//            Thread.sleep(1000);
        }

    }

    private static void aiTurn_2() {
        int row;
        int column;

        System.out.println("AI turn");

        do {
            row = rnd.nextInt(SIZE);
            column = rnd.nextInt(SIZE);
        } while (!isCellFree(row, column));

        field[row][column] = DOT_HUMAN;
        turnCount++;
        lastColumn = column;
        lastRow = row;
    }

    private static boolean isGameEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Human WIN !!!!");
            } else {
                System.out.println("AI WIN !");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
//        if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol) {
//            return true;
//        }
//        if (field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol) {
//            return true;
//        }
//        if (field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) {
//            return true;
//        }
//
//        if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) {
//            return true;
//        }
//        if (field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol) {
//            return true;
//        }
//        if (field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) {
//            return true;
//        }
//
//        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
//            return true;
//        }
//        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
//            return true;
//        }

        if (isRowWin(symbol)) {
            return true;
        }
        if (isColumnWin(symbol)) {
            return true;
        }
        if (isDiagonalsWin(symbol)) {
            return true;
        }

        return false;
    }

    private static boolean isColumnWin(char symbol) {
        winnerCount = 0;
        for (int i = 0; i < SIZE; i++) {
            if (checkWinCondition(field[i][lastColumn], symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(char symbol) {
        winnerCount = 0;
        for (int i = 0; i < SIZE; i++) {
            if (checkWinCondition(field[lastRow][i], symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalsWin(char symbol) {

        int column = lastColumn;
        int row = lastRow;
        winnerCount = 0;
        //ищем начало диагонали
        //идем  вверх влево
        while (column > 0 && row > 0) {
            column--;
            row--;
        }
        // вниз вправо
        while (column < SIZE && row < SIZE) {
            if (checkWinCondition(field[row++][column++], symbol)) {
                return true;
            }
        }

        // ищем начало диагонали
        // идем  вверх вправо
        column = lastColumn;
        row = lastRow;
        winnerCount = 0;
        while (column < SIZE - 1 && row > 0) {
            column++;
            row--;
        }
        // вниз влево
        while (column >= 0 && row < SIZE) {
            if (checkWinCondition(field[row++][column--], symbol)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWinCondition(char fieldSymbol, char symbol) {
        if (fieldSymbol == symbol) {
            return ++winnerCount == WINNING_LENGTH;
        }
        winnerCount = 0;
        return false;
    }


    private static boolean checkDraw() {
        return turnCount >= SIZE * SIZE;
    }

    private static void aiTurn() {

        int row;
        int column;

        System.out.println("AI turn");

        do {
            row = rnd.nextInt(SIZE);
            column = rnd.nextInt(SIZE);
        } while (!isCellFree(row, column));

        field[row][column] = DOT_AI;
        turnCount++;
        lastColumn = column;
        lastRow = row;
    }

    private static void humanTurn() {

        int row;
        int column;

        System.out.println("Human turn");

        while (true) {
            System.out.print("Enter row:");
            row = getValidCoordinate() - 1;
            System.out.print("Enter column:");
            column = getValidCoordinate() - 1;
            if (isCellFree(row, column)) {
                break;
            } else {
                System.out.printf("Cell %d:%d is filled. Enter another coordinate%n", row + 1, column + 1);
            }
        }

        field[row][column] = DOT_HUMAN;
        turnCount++;
        lastRow = row;
        lastColumn = column;
    }

    private static boolean isCellFree(int row, int column) {
        return field[row][column] == DOT_EMPTY;
    }

    private static int getValidCoordinate() {
        while (true) {
            if (in.hasNextInt()) {
                int coordinate = in.nextInt();
                if (isValidCoordinate(coordinate)) {
                    return coordinate;
                }
                System.out.printf("Coordinate must be between 1 and %d. Enter coordinate%n", SIZE);
            } else {
                System.out.println("Coordinate must be integer number");
                in.next();
            }
        }
    }

    private static boolean isValidCoordinate(int coordinate) {
        return coordinate >= 1 && coordinate <= SIZE;
    }

    private static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showField() {
        System.out.printf("%2s%s", HEADER_FIRST_SYMBOL, SPACE_SYMBOL);
        for (int i = 0; i < SIZE; i++) {
            if (SIZE >= 9) {
                System.out.printf("%2s%s", i + 1, SPACE_SYMBOL);
            } else {
                System.out.printf("%s%s", i + 1, SPACE_SYMBOL);

            }
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d%s", i + 1, SPACE_SYMBOL);
            for (int j = 0; j < SIZE; j++) {
                if (SIZE >= 9) {
                    System.out.printf("%2s%s", field[i][j], SPACE_SYMBOL);
                } else {
                    System.out.printf("%s%s", field[i][j], SPACE_SYMBOL);

                }
            }
            System.out.println();
        }
    }
}
