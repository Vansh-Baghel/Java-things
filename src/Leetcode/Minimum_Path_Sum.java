package Leetcode;

import java.util.Arrays;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = {{5,9,6}, {11,5,2}};
        int ans = minSumPath4(arr);
        System.out.println(ans);
    }

    public static int minSumPath(int[][] grid) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        int m = grid.length;
        int n = grid[0].length;
        return totalPaths(grid, m-1,n-1);
    }

    private static int totalPaths(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[0][0];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (m != 0) up = totalPaths(grid,m-1, n) + grid[m][n];
        if (n != 0) left = totalPaths(grid, m, n-1) + grid[m][n];

        return Math.min(up, left);
    }

    // Using memoization
    public static int minSumPath2(int[][] grid) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return totalPaths2(grid, m-1,n-1, dp);
    }

    private static int totalPaths2(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return grid[0][0];
        if (dp[m][n] != -1) return dp[m][n];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (m != 0) up = totalPaths2(grid,m-1, n, dp) + grid[m][n];
        if (n != 0) left = totalPaths2(grid, m, n-1, dp) + grid[m][n];

        return dp[m][n] = Math.min(up, left);
    }

    // Using tabular
    public static int minSumPath3(int[][] grid) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (i > 0) up = dp[i-1][j] + grid[i][j];
                if (j > 0) left = dp[i][j-1] + grid[i][j];

                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[m-1][n-1];
    }

    // Space optimized
    public static int minSumPath4(int[][] grid) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        int[] cur = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[0] = grid[0][0];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (i > 0) up = prev[j] + grid[i][j];
                if (j > 0) left = cur[j-1] + grid[i][j];
                cur[j] = Math.min(up, left);
            }
            prev=cur;
        }
        return cur[n-1];
    }
}
