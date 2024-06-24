package Leetcode;

import java.util.Arrays;

public class Coin_Change {
    public static void main(String[] args) {
        int[] a = {1,2,5};
        System.out.println(coinChange3(a, 11));
    }

    static int coinChange(int[] coins, int amount) {
        int res = totalCoins(coins.length - 1, amount, coins);
        return res == 100000 ? -1 : res;
    }

    private static int totalCoins(int i, int amount, int[] coins) {
        if (amount == 0) return 0;
        if (i < 0 || amount < 0) return 100000;

        int notPick = totalCoins(i - 1, amount, coins);
        int pick = 100000;
        if (coins[i] <= amount) pick = 1 + totalCoins(i, amount - coins[i], coins);

        return Math.min(pick, notPick);
    }

    static int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] r: dp) Arrays.fill(r, -1);
        int res = totalCoins(coins.length - 1, amount, coins, dp);
        return res == 100000 ? -1 : res;
    }

    private static int totalCoins(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 0;
        if (i < 0 || amount < 0) return 100000;

        if (dp[i][amount] != -1) return dp[i][amount];

        int notPick = totalCoins(i - 1, amount, coins, dp);
        int pick = 100000;
        if (coins[i] <= amount) pick = 1 + totalCoins(i, amount - coins[i], coins, dp);

        return dp[i][amount] = Math.min(pick, notPick);
    }

    static int coinChange3(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int)(1e9);
        }

        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notPick = dp[i - 1][tar];
                int pick = 100000;
                if (coins[i] <= tar) pick = 1 + dp[i][tar - coins[i]];

                dp[i][tar] = Math.min(pick, notPick);
            }
        }

        return dp[n-1][amount] == 100000 ? -1 : dp[n-1][amount];
    }
}
