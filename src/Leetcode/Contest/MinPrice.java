package Leetcode.Contest;

import java.util.Arrays;

public class MinPrice {
    public static void main(String[] args) {
        int[] p = {10,20,5,3};
        int[] f = {2,0,1,1};
        System.out.println(minCost(4,p,f));
    }
    public static long minCost(int n, int[] p, int[] f) {
        long[][] dp = new long[n][n+1];
        for (long[] row: dp) Arrays.fill(row, -1);
        return dpFn2(n - 1, n, p, f, dp);
    }

    private static long dpFn(int idx, int n, int[] p, int[] f) {
        if (idx < 0 && n > 0) return 1000000000;
        if (idx < 0 || n == 0) return 0;

        long pick = p[idx] + dpFn(idx - 1, n - f[idx] - 1, p, f);
        long notPick = dpFn(idx - 1, n, p, f);

        return Math.min(pick, notPick);
    }

    private static long dpFn2(int idx, int n, int[] p, int[] f, long[][] dp) {
        if (idx < 0 && n > 0) return 1000000000;
        if (idx < 0 || n == 0) return 0;
        if (n < 0) return 0;

        if (dp[idx][n] != -1) return dp[idx][n];
        long pick = p[idx] + dpFn2(idx - 1, n - f[idx] - 1, p, f, dp);
        long notPick = dpFn2(idx - 1, n, p, f, dp);

        return dp[idx][n] = Math.min(pick, notPick);
    }
}
