package Leetcode;

import java.util.Arrays;

public class Reach_the_Nth_point {
    static int nthPoint(int n) {
        return totalSteps(n);
    }

    private static int totalSteps(int idx) {
        if (idx < 0) return 0;
        if (idx == 0) return 1;

        int one = totalSteps(idx - 1);
        int two = totalSteps(idx - 2);

        return one + two;
    }

    static int mod = (int)1e9+7;

    static int nthPoint2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return totalSteps(n, dp);
    }

    private static int totalSteps(int idx, int[] dp) {
        if (idx < 0) return 0;
        if (idx == 0) return 1;

        if (dp[idx] != -1) return dp[idx];
        int one = totalSteps(idx - 1, dp);
        int two = totalSteps(idx - 2, dp);

        return dp[idx] = (one + two) % mod;
    }
}
