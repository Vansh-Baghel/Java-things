package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public static int stockProfit(int[] prices) {
        int n= prices.length;
        return stockProfit3(prices);
    }

    private static int getProfit(int[] prices, int idx, boolean canBuy, int n) {
        if (idx >= n) return 0;

        int pick;
        int notPick;
        int profit;

        if (canBuy){
            pick = -prices[idx] + getProfit(prices, idx + 2, false, n);
            notPick = getProfit(prices, idx + 1, true, n);
        }
        else {
            pick = prices[idx] + getProfit(prices, idx + 1, true, n);
            notPick = getProfit(prices, idx + 1, false, n);
        }
        profit = Math.max(pick, notPick);
        return profit;
    }

    public static int stockProfit2(int[] prices) {
        int n= prices.length;

        int[][] dp = new int[n][2];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return getProfit2(0, n, 1, prices, dp);
    }

    private static int getProfit2(int idx, int n, int canBuy, int[] prices, int[][] dp) {
        // No need to handle the condition where we buy last element, since it will return a negative number which will be smaller than 0.
        if (idx >= n) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int pick;
        int notPick;
        int profit;

        if (canBuy == 1){
            pick = -prices[idx] + getProfit2(idx + 1, n, 0, prices, dp);
            notPick = getProfit2(idx + 1, n, 1, prices, dp);
        } else {
            pick = prices[idx] + getProfit2(idx + 2, n, 1, prices, dp);
            notPick = getProfit2(idx + 1, n, 0, prices, dp);
        }
        profit = Math.max(pick, notPick);
        return dp[idx][canBuy]=profit;
    }

     static int stockProfit3(int[] prices) {
        // prev nhi, yaha ahead aayega
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        int pick;
        int notPick;

        for (int idx = n-1; idx >= 0; idx--) {

            // we could have also added a for loop for 0 and 1 value for sell.

            // Buying
            pick = -prices[idx] + dp[idx + 1][1];
            notPick = dp[idx + 1][0];
            dp[idx][0]= Math.max(pick, notPick);

            // Selling
            pick = prices[idx] + dp[idx + 2][0];
            notPick = dp[idx + 1][1];
            dp[idx][1]= Math.max(pick, notPick);
        }

        return dp[0][0];
    }
}
