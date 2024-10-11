package org.example;

import java.util.Random;

public class laba1 {

    public static void main(String[] args) {
        try {
            int studentId = 2;
            int sizeMatrix = 5;
            Object matrixB;

            System.out.println("Номер студента: " + studentId);
            int c5 = studentId % 5;
            int c7 = studentId % 7;
            int c11 = studentId % 11;
            System.out.println("Залишок від ділення на 5: " + c5);
            System.out.println("Залишок від ділення на 7: " + c7);
            System.out.println("Залишок від ділення на 11: " + c11);

            System.out.println("Створення байтової матриці.");
            matrixB = generateByteMatrix(sizeMatrix);
            System.out.println("Матриця B:");
            printMatrix(matrixB);

            System.out.println("Створення транспонованої матриці.");
            Object transposedMatrix = transposeMatrix(matrixB);
            if (transposedMatrix != null) {
                System.out.println("Транспонована матриця B:");
                printMatrix(transposedMatrix);
            }

            System.out.println("Обчислення суми найбільших елементів у кожному стовпці матриці");
            float sumMax_original = sumMaxInCol(matrixB, sizeMatrix);
            System.out.println("Сума найбільших елементів у кожному стовпці матриці B: " + sumMax_original);

            float sumMax_transopse = sumMaxInCol(transposedMatrix, sizeMatrix);
            System.out.println("Сума найбільших елементів у кожному стовпці транспонованої матриці B: " + sumMax_transopse);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static byte[][] generateByteMatrix(int size) {
        Random rand = new Random();
        byte[][] byteMatrix = new byte[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                byteMatrix[i][j] = (byte) rand.nextInt(256);
            }
        }
        return byteMatrix;
    }

    public static Object transposeMatrix(Object matrix) {
        if (matrix instanceof byte[][]) {
            byte[][] original = (byte[][]) matrix;
            byte[][] result = new byte[original[0].length][original.length];
            for (int i = 0; i < original.length; i++) {
                for (int j = 0; j < original[0].length; j++) {
                    result[j][i] = original[i][j];
                }
            }
            return result;
        }
        return null;
    }

    public static float sumMaxInCol(Object matrix, int size) {
        float sum = 0;
        if (matrix instanceof byte[][]) {
            byte[][] byteMatrix = (byte[][]) matrix;
            for (int i = 0; i < size; i++) {
                byte max = byteMatrix[0][i];
                for (int j = 1; j < size; j++) {
                    if (byteMatrix[j][i] > max) {
                        max = byteMatrix[j][i];
                    }
                }
                sum += max;
            }
        }
        return sum;
    }

    public static void printMatrix(Object matrix) {
        if (matrix instanceof byte[][]) {
            for (byte[] row : (byte[][]) matrix) {
                for (byte value : row) {
                    System.out.printf("%4d", value);
                }
                System.out.println();
            }
        }
    }
}
