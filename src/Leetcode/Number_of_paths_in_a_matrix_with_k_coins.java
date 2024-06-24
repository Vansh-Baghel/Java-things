package Leetcode;

import java.util.Arrays;

public class Number_of_paths_in_a_matrix_with_k_coins {
    static long numberOfPath(int n, int k, int [][]arr) {
        return solve(n - 1, n - 1, k, arr);
    }

    static long solve(int i, int j, int k, int[][] arr){
        if (i < 0 || j < 0) return 0;

        if (i == 0 && j == 0 && k == arr[0][0]) return 1;

        long up = solve(i - 1, j, k - arr[i][j], arr);
        long left = solve(i, j - 1, k - arr[i][j], arr);

        return up + left;
    }

    static long numberOfPath2(int n, int k, int [][]arr) {
        long[][][] dp = new long[n][n][k+1];

        for (long[][] d: dp){
            for (long[] r: d){
                Arrays.fill(r, -1);
            }
        }

        return solve(n - 1, n - 1, k, arr, dp);
    }

    static long solve(int i, int j, int k, int[][] arr, long[][][] dp){
        if (i < 0 || j < 0 || k < 0) return 0;

        if (i == 0 && j == 0 && k == arr[0][0]) return 1;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        long up = solve(i - 1, j, k - arr[i][j], arr, dp);
        long left = solve(i, j - 1, k - arr[i][j], arr, dp);

        return dp[i][j][k] = up + left;
    }
}
