package Leetcode;

public class Difference_Between_Ones_and_Zeros_in_Row_and_Column {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];

        int[] oneRow = new int[n];
        int[] oneCol = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    oneRow[i]++;
                    oneCol[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (oneRow[i] - (n - oneRow[i])) + (oneCol[j] - (n - oneCol[j]));
            }
        }

        return res;
    }
}
