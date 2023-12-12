package Leetcode;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static void main(String[] args) {
        int[] arr = {1,3,2,8,4,9};
        int[] arr1 = {2, 4, 3, 4, 5};
        int n = arr.length;
        System.out.println(maxProfit3(arr, 2));
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
                    pick = -prices[idx] + dp[idx + 1][1];
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

        for (int[] r: dp){
            for (int c: r){
                System.out.print(c + " ");
            }
            System.out.println();
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
                    pick = -prices[idx] + ahead[1];
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



    static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return greatestProfit(0, 1, n, prices, fee);
    }

    private static int greatestProfit(int idx, int canBuy, int n, int[] prices, int fee) {
        if (idx >= n) return 0;

        int pick = 0, notPick = 0;
        if (canBuy == 1){
            pick = -prices[idx] + greatestProfit(idx + 1, 0, n, prices, fee);
        } else {
            pick = prices[idx] + greatestProfit(idx + 1, 1, n, prices, fee) - fee;
        }

        notPick = greatestProfit(idx + 1, canBuy, n, prices, fee);

        return Math.max(pick, notPick);
    }

    static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] r: dp) Arrays.fill(r, -1);
        return greatestProfit(0, 1, n, prices, fee, dp);
    }

    private static int greatestProfit(int idx, int canBuy, int n, int[] prices, int fee, int[][] dp) {
        if (idx >= n) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int pick = 0, notPick = 0;
        if (canBuy == 1){
            pick = -prices[idx] + greatestProfit(idx + 1, 0, n, prices, fee, dp);
        } else {
            pick = prices[idx] + greatestProfit(idx + 1, 1, n, prices, fee, dp) - fee;
        }

        notPick = greatestProfit(idx + 1, canBuy, n, prices, fee, dp);

        return dp[idx][canBuy] = Math.max(pick, notPick);
    }

    static int maxProfit3(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                int pick = 0, notPick = 0;
                if (canBuy == 0){
                    pick = -prices[idx] + dp[idx + 1][1];
                } else {
                    pick = prices[idx] + dp[idx + 1][0] - fee;
                }

                notPick = dp[idx + 1][canBuy];

                dp[idx][canBuy] = Math.max(pick, notPick);
            }
        }

        for (int[] r: dp){
            for (int c: r){
                System.out.print(c + " ");
            }
            System.out.println();
        }

        // Since we are selling at 1.
        return dp[0][1];
    }

    static int maxProfit4(int[] prices, int fee) {
        int n = prices.length;
        int[] cur = new int[2];
        int[] nxt = new int[2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                int pick = 0, notPick = 0;
                if (canBuy == 0){
                    pick = -prices[idx] + nxt[1];
                } else {
                    pick = prices[idx] + nxt[0] - fee;
                }

                notPick = nxt[canBuy];

                cur[canBuy] = Math.max(pick, notPick);
            }

            nxt = cur;
        }

        return cur[1];
    }
}
