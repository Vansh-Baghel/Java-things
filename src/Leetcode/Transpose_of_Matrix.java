package Leetcode;

public class Transpose_of_Matrix {
    static void transpose(int n,int a[][]) {
        for (int row = 0; row < n; row++) {
            for (int col =row + 1; col < n; col++) {
                swap(row, col, a);
            }
        }
    }

    private static void swap(int row, int col, int[][] matrix) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }
}
