package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    public static void main(String[] args) {
        int[] values = {3,3,5,0,0,3,1,4};
        int n = values.length;
        System.out.println(maxProfit4(values, n));
    }

    public static int maxProfit(int []prices, int n) {
        return maxProfitIn2Transactions(prices, n, 0, 0, 1);
    }

    private static int maxProfitIn2Transactions(int[] prices, int n, int idx, int cap, int canBuy) {
        if (idx == n || cap == 2) return 0;

        int pick = 0;
        int notPick = 0;
        int profit = 0;

        if (canBuy == 1){
            pick = -prices[idx] + maxProfitIn2Transactions(prices, n, idx+1, cap, 0);
            notPick = maxProfitIn2Transactions(prices, n, idx+1, cap, 1);
        } else {
            pick = prices[idx] + maxProfitIn2Transactions(prices, n, idx+1, cap+1, 1);
            notPick = maxProfitIn2Transactions(prices, n, idx+1, cap, 0);
        }
        profit = Math.max(pick, notPick);
        return profit;
    }

    static int maxProfit2(int []prices, int n) {
        int[][] dp = new int[n][2];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxProfitIn2Transactions2(prices, n, 0, 0, 1,dp);
    }

    static int maxProfitIn2Transactions2(int[] prices, int n, int idx, int cap, int canBuy, int[][] dp) {
        if (idx == n || cap == 2) return 0;
        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int pick = 0;
        int notPick = 0;
        int profit = 0;

        if (canBuy == 1){
            pick = -prices[idx] + maxProfitIn2Transactions2(prices, n, idx+1, cap, 0,dp);
            notPick = maxProfitIn2Transactions2(prices, n, idx+1, cap, canBuy,dp);
        } else {
            pick = prices[idx] + maxProfitIn2Transactions2(prices, n, idx+1, cap+1, 1,dp);
            notPick = maxProfitIn2Transactions2(prices, n, idx+1, cap, canBuy,dp);
        }
        profit = Math.max(pick, notPick);
        return dp[idx][canBuy] = profit;
    }

    public static int maxProfit3(int[] values, int n) {
        int[][][] dp = new int[n+1][2][3];

        for (int idx = 0; idx < n; idx++) {
            for (int cap = 0; cap <= 1; cap++) {
                dp[idx][0][cap] = 0;
                dp[idx][1][cap] = 0;
            }
        }

        for (int idx = 0; idx < n; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                for (int cap = 1; cap <= 2; cap++) {
                    // Here we will buy first
                    if (canSell == 0){
                        pick = -values[idx] + dp[idx+1][1][cap];
                        notPick = dp[idx+1][0][cap];
                        profit = Math.max(pick, notPick);
                    }

                    if (canSell == 1){
                        pick = values[idx] + dp[idx+1][0][cap-1];
                        notPick = dp[idx+1][1][cap];
                        profit = Math.max(pick, notPick);
                    }
                    dp[idx][canSell][cap]=profit;
                }
            }
        }
        return dp[0][0][2];
    }

    public static int maxProfit4(int[] values, int n) {
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

            for (int cap = 0; cap <= 1; cap++) {
                ahead[0][cap] = 0;
        }

        for (int buy = 0; buy <= 1; buy++) {
            ahead[buy][0] = 0;
        }

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                for (int cap = 1; cap <= 2; cap++) {
                    // Here we will buy first
                    if (canSell == 0){
                        pick = -values[idx] + ahead[1][cap];
                        notPick = ahead[0][cap];
                        profit = Math.max(pick, notPick);
                    }

                    if (canSell == 1){
                        pick = values[idx] + ahead[0][cap-1];
                        notPick = ahead[1][cap];
                        profit = Math.max(pick, notPick);
                    }
                    cur[canSell][cap]=profit;
                }
                ahead = cur;
            }
        }
        return cur[0][2];
    }
}
