package Leetcode;

import java.util.Arrays;

public class Knapsack_Problem {
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        return solve(W, n - 1, wt, val);
    }

    static int solve(int w, int idx, int[] wt, int[] arr){
        if (w <= 0 || idx < 0) return 0;

        int pick = 0;
        if (w - wt[idx] >= 0) pick = arr[idx] + solve(w - wt[idx], idx - 1, wt, arr);
        int notPick = solve(w, idx - 1, wt, arr);

        return Math.max(pick, notPick);
    }

    static int knapSack2(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[n][W+1];
        for (int[] r: dp) Arrays.fill(r, -1);
        return solve(W, n - 1, wt, val, dp);
    }

    static int solve(int w, int idx, int[] wt, int[] arr, int[][] dp){
        if (w <= 0 || idx < 0) return 0;

        if (dp[idx][w] != -1) return dp[idx][w];

        int pick = 0;
        if (w - wt[idx] >= 0) pick = arr[idx] + solve(w - wt[idx], idx - 1, wt, arr, dp);
        int notPick = solve(w, idx - 1, wt, arr, dp);

        return dp[idx][w] = Math.max(pick, notPick);
    }

    static int knapSack3(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W+1];

        // First weight se zyada hua toh hee index 0 of further weights can have the val[idx]
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int w = 0; w <= W; w++) {
                int pick = Integer.MIN_VALUE;
                if (w - wt[idx] >= 0) pick = val[idx] + dp[idx - 1][w - wt[idx]];
                int notPick = dp[idx - 1][w];
                dp[idx][w] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][W];
    }
}
