package Leetcode;

public class Transpose_Matrix {
    static int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[m][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
//                swap(row, col, matrix, res);
                if (res[col][row] != 0) continue;
                res[col][row] = matrix[row][col];
            }
        }

        return res;
    }
//
//    private static void swap(int row, int col, int[][] matrix, int[][] res) {
//        int temp = matrix[row][col];
//        matrix[row][col] = matrix[col][row];
//        matrix[col][row] = temp;
//    }
}
