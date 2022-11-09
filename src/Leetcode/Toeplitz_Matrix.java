package Leetcode;

public class Toeplitz_Matrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(mat));
    }

    static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
//                Checked if the next element in a row is shorter than the length of the row and if the next row is smaller than the length of the matrix or not.
                if (matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
        }
}
