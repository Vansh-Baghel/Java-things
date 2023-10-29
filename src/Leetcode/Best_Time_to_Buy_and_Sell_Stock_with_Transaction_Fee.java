package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 63, 3, 6};
        int[] arr1 = {2, 4, 3, 4, 5};
        int n = arr.length;
        System.out.println(maximumProfit(arr, n, 1));
    }

    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                // Here we will buy first
                if (canSell == 0){
                    pick = -prices[idx] - fee + dp[idx + 1][1];
                    notPick = dp[idx + 1][0];
                    profit = Math.max(pick, notPick);
                }

                if (canSell == 1){
                    pick = prices[idx] + dp[idx + 1][0];
                    notPick = dp[idx + 1][1];
                    profit = Math.max(pick, notPick);
                }
                dp[idx][canSell]=profit;
            }
        }
        return dp[0][0];
    }

    public static int maximumProfit2(int[] prices, int n, int fee) {
        // Write your code here.
        int[] ahead = new int[n+1];
        int[] cur = new int[n+1];

        ahead[0] = 0;

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int canSell = 0; canSell <= 1; canSell++) {
                // Here we will buy first
                if (canSell == 0){
                    pick = -prices[idx] - fee + ahead[1];
                    notPick = ahead[0];
                    profit = Math.max(pick, notPick);
                }

                if (canSell == 1){
                    pick = prices[idx] + ahead[0];
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
