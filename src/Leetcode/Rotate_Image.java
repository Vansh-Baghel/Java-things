//https://leetcode.com/problems/rotate-image/description/
package Leetcode;

public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int tmp = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                tmp = 0;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
