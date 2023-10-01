package bigdata.matrix;

import java.util.Random;

public class Matrix {
    public static double[][] generateRandomMatrix(int size) {
        double[][] matrix = new double[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }
        return matrix;
    }

    public static void multiplyMatrices(double[][] a, double[][] b, double[][] c) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }
}
