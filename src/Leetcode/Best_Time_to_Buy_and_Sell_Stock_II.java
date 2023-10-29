package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        long[] values = {7,1,5,3};
        int n = values.length;
        System.out.println(getMaximumProfit4(n, values));
    }

    public static long getMaximumProfit (int n, long[] values) {
        return maxProfit(0, n, true, values);
    }

    private static long maxProfit(int idx, int n, boolean canBuy, long[] values) {
        if (idx == n) return 0;

        long pick;
        long notPick;
        if (canBuy){
            pick = -values[idx] + maxProfit(idx + 1, n, false, values);
            notPick = maxProfit(idx + 1, n, true, values);
        } else {
            pick = values[idx] + maxProfit(idx + 1, n, true, values);
            notPick = maxProfit(idx + 1, n, false, values);
        }
        return Math.max(pick, notPick);
    }

    public static long getMaximumProfit2 (int n, long[] values) {
        long[][] dp = new long[n][2];
        for (long[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxProfit2(0, n, 1, values, dp);
    }

    private static long maxProfit2(int idx, int n, int canBuy, long[] values, long[][] dp) {
        // No need to handle the condition where we buy last element, since it will return a negative number which will be smaller than 0.
        if (idx == n) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        long pick;
        long notPick;
        long profit;

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

    public static long getMaximumProfit3 (int n, long[] values) {
        long[][] dp = new long[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        long pick;
        long notPick;
        long profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                // Here we will buy first
                if (canSell == 0){
                    pick = -values[idx] + dp[idx + 1][1];
                    notPick = dp[idx + 1][0];
                    profit = Math.max(pick, notPick);
                }

                if (canSell == 1){
                    pick = values[idx] + dp[idx + 1][0];
                    notPick = dp[idx + 1][1];
                    profit = Math.max(pick, notPick);
                }
                dp[idx][canSell]=profit;
            }
        }
        return dp[0][0];
    }

    public static long getMaximumProfit4(int n, long[] values) {
        // prev nhi, yaha ahead aayega
        long[] ahead = new long[n+1];
        long[] cur = new long[n+1];

        ahead[0] = 0;

        long pick;
        long notPick;
        long profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                // Here we will buy first
                if (canSell == 0){
                    pick = -values[idx] + ahead[1];
                    notPick = ahead[0];
                    profit = Math.max(pick, notPick);
                }

                if (canSell == 1){
                    pick = values[idx] + ahead[0];
                    notPick = ahead[1];
                    profit = Math.max(pick, notPick);
                }
                cur[canSell]=profit;
            }
            ahead = cur;
        }
        return ahead[0];
    }
}
