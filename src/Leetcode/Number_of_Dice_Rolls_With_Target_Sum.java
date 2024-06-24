package Leetcode;

import java.util.Arrays;

public class Number_of_Dice_Rolls_With_Target_Sum {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget2(2, 6, 7));
    }

    static int mod = 1000000000 + 7;

    static int numRollsToTarget(int n, int k, int target) {
        if (n < 0 || target < 0) return 0;
        if (target == 0) return 1;

        int pick = 0;

        for (int i = 1; i <= k; i++) {
            pick += numRollsToTarget(n - 1, k, target - i) % mod;
        }

        return pick;
    }

    static int numRollsToTarget2(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] r : dp) Arrays.fill(r, -1);

        return totalWays(n, k, target, dp);
    }

    static int totalWays(int n, int k, int target, int[][] dp) {
        if (target == 0 && n == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return (int)(dp[n][target] % mod);

        int pick = 0;

        for (int i = 1; i <= k; i++) {
            pick = (pick + totalWays(n - 1, k, target - i, dp)) % mod;
        }

        return dp[n][target] = pick % mod;
    }
}