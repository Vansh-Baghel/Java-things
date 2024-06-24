package Leetcode.Contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Maximize_dot_product {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[] a = {2, 3, 1, 7, 8};
        int[] b = {3, 6, 7};

        System.out.println(maxDotProduct(n,m,a,b));
    }

    public static int maxDotProduct(int n, int m, int a[], int b[]) {
        // Your code goes here
        int[][] dp = new int[n][m];
        for (int[] r: dp) Arrays.fill(r, -1);
        return solve(n-1, m-1, a, b, dp);
    }

    public static int solve (int n, int m, int a[], int b[], int[][] dp) {
        if (m < 0) {
            return 0;
        }

        if (n < 0) {
            return -1_0000_0000;
        }

        if (dp[n][m] != -1) return dp[n][m];

        int pick = (a[n] * b[m]) + solve(n - 1, m - 1, a, b, dp);
        int notPick = solve(n - 1, m, a, b, dp);

        return dp[n][m] = Math.max(pick, notPick);
    }
}
