package Leetcode;

public class Determinant_of_a_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 10, 9}
        };

        System.out.println(determinantOfMatrix(matrix, matrix.length));
    }

    static int determinantOfMatrix(int matrix[][], int n) {
        // code here
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;

        for (int j = 0; j < n; j++) {
            det += matrix[0][j] * cofactor(matrix, n, 0, j);
        }

        return det;
    }

    private static int cofactor(int[][] matrix, int n, int row, int col) {
        int[][] subMatrix = new int[n - 1][n - 1];
        int subRow = 0, subCol = 0;

        for (int i = 0; i < n; i++) {
            if (i != row){
                subCol = 0;
                for (int j = 0; j < n; j++) {
                    if (j != col) {
                        subMatrix[subRow][subCol] = matrix[i][j];
                        subCol++;
                    }
                }
                subRow++;
            }
        }

        return (int) Math.pow(-1, col) * determinantOfMatrix(subMatrix, n - 1);
    }
}
