package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        int[] values = {7,1,5,3};
        int n = values.length;
        System.out.println(getMaximumProfit4(n, values));
    }

    public static int getMaximumProfit (int n, int[] values) {
        return maxProfit(0, n, true, values);
    }

    private static int maxProfit(int idx, int n, boolean canBuy, int[] values) {
        if (idx == n) return 0;

        int pick;
        int notPick;
        if (canBuy){
            pick = -values[idx] + maxProfit(idx + 1, n, false, values);
            notPick = maxProfit(idx + 1, n, true, values);
        } else {
            pick = values[idx] + maxProfit(idx + 1, n, true, values);
            notPick = maxProfit(idx + 1, n, false, values);
        }
        return Math.max(pick, notPick);
    }

    public static int getMaximumProfit2 (int n, int[] values) {
        int[][] dp = new int[n][2];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxProfit2(0, n, 1, values, dp);
    }

    private static int maxProfit2(int idx, int n, int canBuy, int[] values, int[][] dp) {
        // No need to handle the condition where we buy last element, since it will return a negative number which will be smaller than 0.
        if (idx == n) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int pick;
        int notPick;
        int profit;

        if (canBuy == 1){
            pick = -values[idx] + maxProfit2(idx + 1, n, 0, values, dp);
            notPick = maxProfit2(idx + 1, n, 1, values, dp);
        } else {
            pick = values[idx] + maxProfit2(idx + 1, n, 1, values, dp);
            notPick = maxProfit2(idx + 1, n, 0, values, dp);
        }
        profit = Math.max(pick, notPick);
        return dp[idx][canBuy]=profit;
    }

    public static int getMaximumProfit3 (int n, int[] values) {
        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                // Here we will buy first
                if (canBuy == 0){
                    pick = -values[idx] + dp[idx + 1][1];
                    notPick = dp[idx + 1][0];
                    profit = Math.max(pick, notPick);
                }

                if (canBuy == 1){
                    pick = values[idx] + dp[idx + 1][0];
                    notPick = dp[idx + 1][1];
                    profit = Math.max(pick, notPick);
                }
                dp[idx][canBuy]=profit;
            }
        }
        return dp[0][0];
    }

    public static int getMaximumProfit4(int n, int[] values) {
        // prev nhi, yaha ahead aayega
        int[] ahead = new int[n+1];
        int[] cur = new int[n+1];

        ahead[0] = 0;

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                // Here we will buy first
                if (canBuy == 0){
                    pick = -values[idx] + ahead[1];
                    notPick = ahead[0];
                    profit = Math.max(pick, notPick);
                }

                if (canBuy == 1){
                    pick = values[idx] + ahead[0];
                    notPick = ahead[1];
                    profit = Math.max(pick, notPick);
                }
                cur[canBuy]=profit;
            }
            ahead = cur;
        }
        return ahead[0];
    }












    public int maxProfit(int[] prices) {
        int n = prices.length;
        return findMaxProfit(prices, 0, n, true);
    }

    private int findMaxProfit(int[] prices, int idx, int n, boolean canBuy) {
        if (idx == n) return 0;

        int pick = 0;
        if (canBuy) {
            pick = -prices[idx] + findMaxProfit(prices, idx + 1, n, false);
        }
        else {
            pick = prices[idx] + findMaxProfit(prices, idx + 1, n, true);
        }

        int notPick = findMaxProfit(prices, idx + 1, n, canBuy);

        return Math.max(pick, notPick);
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] r: dp){
            Arrays.fill(r, -1);
        }

        return findMaxProfit(prices, 0, n, 1, dp);
    }

    private int findMaxProfit(int[] prices, int idx, int n, int canBuy, int[][] dp) {
        if (idx == n) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int pick = 0;
        if (canBuy == 1) {
            pick = -prices[idx] + findMaxProfit(prices, idx + 1, n, 0, dp);
        }
        else {
            pick = prices[idx] + findMaxProfit(prices, idx + 1, n, 1, dp);
        }

        int notPick = findMaxProfit(prices, idx + 1, n, canBuy, dp);

        return dp[idx][canBuy] = Math.max(pick, notPick);
    }

    static int maxProfit3(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int pick;

                if (canBuy == 1) {
                    pick = -prices[idx] + dp[idx + 1][0];
                }
                else {
                    pick = prices[idx] + dp[idx + 1][1];
                }

                int notPick = dp[idx + 1][canBuy];

                dp[idx][canBuy] = Math.max(pick, notPick);
            }
        }

        return dp[0][1];
    }

    static int maxProfit4(int[] prices) {
        int n = prices.length;

        int[] cur = new int[2];
        int[] nxt = new int[2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int pick;

                if (canBuy == 1) {
                    pick = -prices[idx] + nxt[0];
                }
                else {
                    pick = prices[idx] + nxt[1];
                }

                int notPick = nxt[canBuy];

                cur[canBuy] = Math.max(pick, notPick);
            }

            nxt = cur;
        }

        return cur[1];
    }
}
