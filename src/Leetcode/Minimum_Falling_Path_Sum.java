package Leetcode;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] array = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int ans = minFallingPathSum4(array);
        System.out.println(ans);
    }

    // Using DP: Memoization
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            min = Math.min(minCount(matrix, n-1, j, n), min);
        }
        return min;
    }

    static int minCount(int[][] matrix, int i, int j, int n) {
        if (i == 0) return matrix[0][j];

        int left = (int)Math.pow(10,9);
        int right = (int)Math.pow(10,9);

        int down = minCount(matrix, i-1,j, n) + matrix[i][j];
        if (j > 0) left = minCount(matrix, i-1,j-1, n) + matrix[i][j];
        if (j < n-1) right = minCount(matrix, i-1,j+1, n) + matrix[i][j];

        return Math.min(down, Math.min(left, right));
    }

    // Using DP: Memoization
    static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;

        int dp[][]= new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        for (int j = 0; j < m; j++) {
            min = Math.min(minCount2(matrix, n-1, j, n, dp), min);
        }
        return min;
    }

    static int minCount2(int[][] matrix, int i, int j, int n, int[][] dp) {
        if (i == 0) return matrix[0][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int down = (int)Math.pow(10,9);
        int left = (int)Math.pow(10,9);
        int right = (int)Math.pow(10,9);

        down = minCount2(matrix, i-1,j, n, dp) + matrix[i][j];
        if (j > 0) left = minCount2(matrix, i-1,j-1, n, dp) + matrix[i][j];
        if (j < n-1) right = minCount2(matrix, i-1,j+1, n, dp) + matrix[i][j];

        return dp[i][j] = Math.min(down, Math.min(left, right));
    }

    // Using DP: Tabulation
    static int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][]= new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int left = (int)Math.pow(10,9);
                    int right = (int)Math.pow(10,9);

                    int down = dp[i-1][j] + matrix[i][j];
                    if (j > 0) left = dp[i-1][j-1] + matrix[i][j];
                    if (j < n-1) right = dp[i-1][j+1] + matrix[i][j];

                    dp[i][j] = Math.min(down, Math.min(left, right));
                }
            }
        int mini = Integer.MAX_VALUE;

        for(int j=0; j<m;j++){
            mini = Math.min(mini,dp[n-1][j]);
        }

        return mini;
    }

    // Using DP: Tabulation
    static int minFallingPathSum4(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev= new int[m];
        int[] cur= new int[m];

        for (int i = 0; i < m; i++) {
            prev[i] = matrix[0][i];
        }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int left = (int)Math.pow(10,9);
                    int right = (int)Math.pow(10,9);

                    int down = prev[j] + matrix[i][j];
                    if (j > 0) left = prev[j-1] + matrix[i][j];
                    if (j < n-1) right = prev[j+1] + matrix[i][j];

                    cur[j] = Math.min(down, Math.min(left, right));
                }
                prev=cur;
            }
        int mini = Integer.MAX_VALUE;

        for(int j=0; j<m;j++){
            mini = Math.min(mini,prev[j]);
        }

        return mini;
    }
}
