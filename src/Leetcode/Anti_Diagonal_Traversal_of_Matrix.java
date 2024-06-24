package Leetcode;

import java.util.Arrays;

public class Anti_Diagonal_Traversal_of_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 3},
                {4, 5, 1},
                {7, 8, 9}
        };

        System.out.println(Arrays.toString(antiDiagonalPattern(matrix)));
    }

    static int idx = 0;

    static int[] antiDiagonalPattern(int[][] matrix){
        int n = matrix.length, idx = 0;
        int[] res = new int[n * n];

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n; j++) {
                addDiagonal(i, j, n, res, matrix);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j > n - 2; j--) {
                addDiagonal(i, j, n, res, matrix);
            }
        }

        return res;
    }

    static void addDiagonal(int i, int j, int n, int[] res, int[][] matrix) {
        if (i >= n || j < 0) return;

        res[idx++] = matrix[i][j];

        addDiagonal(i + 1, j - 1, n, res, matrix);
    }
}
