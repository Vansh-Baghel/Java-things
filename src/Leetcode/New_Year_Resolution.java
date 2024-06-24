package Leetcode;

import java.util.Arrays;

public class New_Year_Resolution {
    public static void main(String[] args) {
        int[] nums = {17,3};
        int n = nums.length;
        System.out.println(isPossible(n, nums));
    }

    public static boolean isPossible(int N, int[] coins) {
        // code here
        return happyNewYear(N - 1, 0, coins);
    }

    private static boolean happyNewYear(int idx, int sum, int[] coins) {
        if (sum != 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024)) return true;
        if (idx < 0) return false;

        boolean pick = happyNewYear(idx - 1, sum + coins[idx], coins);
        boolean notPick = happyNewYear(idx - 1, sum, coins);

        return pick || notPick;
    }

    public static boolean isPossible2(int N, int[] coins) {
        // code here
        int[][] dp = new int[N][2025];

        for (int[] r: dp) Arrays.fill(r, -1);

        return happyNewYear(N - 1, 0, coins, dp);
    }

    private static boolean happyNewYear(int idx, int sum, int[] coins, int[][] dp) {
        if (sum != 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024)) return true;
        if (idx < 0) return false;

        if (dp[idx][sum] != -1) return dp[idx][sum] == 1;

        boolean pick = happyNewYear(idx - 1, sum + coins[idx], coins, dp);
        boolean notPick = happyNewYear(idx - 1, sum, coins, dp);

        boolean res = pick || notPick;
        dp[idx][sum] = res ? 1 : 0;

        return res;
    }
}
