package Leetcode;

import java.util.Arrays;

public class Paths_to_reach_origin {
    public static int ways(int n, int m){
        // complete the function
        int[][] dp = new int[n+1][m+1];

        for (int[] r: dp) Arrays.fill(r, -1);

        return solve(n, m, dp);
    }

    public static int solve(int n, int m, int[][] dp){
        if (n < 0 || m < 0) return 0;
        if (n == 0 && m == 0) return 1;

        if (dp[n][m] != -1) return dp[n][m];

        int left = solve(n - 1, m, dp);
        int down = solve(n, m - 1, dp);

        return dp[n][m] = (left + down) % 1000000007;
    }
}
