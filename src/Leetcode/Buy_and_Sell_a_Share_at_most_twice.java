package Leetcode;

import java.util.*;

public class Buy_and_Sell_a_Share_at_most_twice {
    public static void main(String[] args) {
        int n = 6;
        int prices[] = {10,22,5,75,65,80};

        System.out.println(maxProfit(n, prices));
    }

    public static int maxProfit(int n, int[] price) {
        // code here
        // k = 2, buy = true
        return solve(0, n, 2, true, price);
    }

    public static int solve (int idx, int n, int k, boolean buy, int[] price){
        if (k < 0 || idx == n) return 0;

        int pick = 0, notPick = 0;
        if (buy) {
            pick = -price[idx] + solve (idx + 1, n, k - 1, false, price);
        } else {
            pick = price[idx] + solve (idx + 1, n, k - 1, true, price);
        }

        notPick = solve (idx + 1, n, k - 1, buy, price);

        return Math.max(pick, notPick);
    }

    public static int maxProfit2(int n, int[] price) {
        // code here
        // k = 2, buy = true
        int[][][] dp = new int[n][2][2];
        for (int[][] r: dp){
            for (int[] c: r){
                Arrays.fill(c, -1);
            }
        }

        return solve(0, n, 1, 1, price, dp);
    }

    public static int solve (int idx, int n, int k, int buy, int[] price, int[][][] dp){
        if (k < 0 || idx == n) return 0;

        if (dp[idx][buy][k] != -1) return dp[idx][buy][k];

        int profit = 0;
        int pick;
        if (buy == 1) {
            pick = -price[idx] + solve(idx + 1, n, k, 0, price, dp);
        } else {
            pick = price[idx] + solve(idx + 1, n, k - 1, 1, price, dp);
        }

        int notPick = solve (idx + 1, n, k, buy, price, dp);
        profit = Math.max(pick, notPick);

        return dp[idx][buy][k] = profit;
    }

    public static int maxProfit3(int n, int[] price) {
        // code here
        // k = 2, buy = true
//        int n = price.length;
        int[][][] dp = new int[n+1][2][3];

        for (int idx = n - 1; idx >= 0; idx--) {
            int profit = 0;
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <= 2; k++) {
                    int pick;
                    if (buy == 1) {
                        pick = -price[idx] + dp[idx + 1][0][k];
                    } else {
                        pick = price[idx] + dp[idx + 1][1][k - 1];
                    }

                    int notPick = dp[idx + 1][buy][k];
                    profit = Math.max(pick, notPick);
                    dp[idx][buy][k] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}
