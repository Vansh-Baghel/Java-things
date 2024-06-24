package Leetcode;

import java.util.*;

public class Perfect_Squares {
    public static void main(String[] args) {
        System.out.println(numSquares3(5));
    }

    static int numSquares(int n) {
        return solve(n);
    }

    static int solve(int n){
        if (n == 0) return 0;

        int res = 10000;

        for (int i = 1; i * i <= n; i++){
            int curSum = 1 + solve(n - (i * i));
            res = Math.min(res, curSum);
        }

        return res;
    }

    static int numSquares2(int n) {
         int[] dp = new int[n];

         Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    static int solve(int n, int[] dp){
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int res = 10000;

        for (int i = 1; i * i <= n; i++){
            int curSum = 1 + solve(n - (i * i), dp);
            res = Math.min(res, curSum);
        }

        return dp[n] = res;
    }

    static int numSquares3(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            // Writing this inside for loop, because at every n, we need res to be restarted. Else it will just be 1.
            int res = 10000;

            for (int j = 1; j * j <= i; j++){
                int curSum = 1 + dp[i - (j * j)];
                res = Math.min(res, curSum);
            }
            // Updating the dp at each index
            dp[i] = res;
        }

        return dp[n];
    }
}
