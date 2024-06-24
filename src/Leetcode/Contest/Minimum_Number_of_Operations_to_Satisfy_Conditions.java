package Leetcode.Contest;

import java.util.Arrays;

public class Minimum_Number_of_Operations_to_Satisfy_Conditions {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = Integer.MAX_VALUE;
        int[][] dp = new int[n][10];

        for (int[] r: dp) Arrays.fill(r, -1);

        for (int i = 0; i < 10; i++){
            res = Math.min(res, solve(grid, 0, i, m, n, dp));
        }

        return res;
    }

    public int solve(int[][] grid, int col, int keep, int m, int n, int[][] dp){
        if (col >= n) return 0;

        if (dp[col][keep] != -1) return dp[col][keep];

        int cost = 0, mini = Integer.MAX_VALUE;

        for (int row = 0; row < m; row++){
            if (grid[row][col] != keep) cost++;
        }

        for (int pos = 0; pos<10; pos++){
            if (pos == keep) continue;
            mini = Math.min(mini, cost + solve(grid, col + 1, pos, m, n, dp));
        }

        return dp[col][keep] = mini;
    }
}
