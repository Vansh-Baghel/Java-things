package Leetcode;

import java.util.Arrays;

public class Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] a = {5,11,13};
        int[] b = {2,4,6};
        System.out.println(unboundedKnapsack3(3,10,a,b));
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return maxProfit(n-1,w,profit,weight);
    }

    static int maxProfit(int n, int w, int[] profit, int[] weight) {
       if (n == 0) {
           if (w % weight[n] == 0) {
               return w / weight[n] * profit[n];
           }
       }

       int pick = 0;
       if (weight[n] <= w) pick = profit[n] + maxProfit(n, w - weight[n], profit, weight);
       int notPick = maxProfit(n - 1, w, profit, weight);

        return Math.max(pick, notPick);
    }

    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for (int[] r: dp) Arrays.fill(r, -1);
        return maxProfit2(n-1,w,profit,weight, dp);
    }

    static int maxProfit2(int n, int w, int[] profit, int[] weight, int[][] dp) {
       if (n == 0) {
           if (w % weight[n] == 0) {
               return w / weight[n] * profit[n];
           }
       }

       if (dp[n][w] != -1) return dp[n][w];

       int pick = 0;
       if (weight[n] <= w) pick = profit[n] + maxProfit2(n, w - weight[n], profit, weight, dp);
       int notPick = maxProfit2(n - 1, w, profit, weight, dp);

        return dp[n][w] = Math.max(pick, notPick);
    }

    public static int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];

        // Filling all the w range with the possibilities of getting max profit in w range wrt weight[0].
        for (int i = weight[0]; i <= w; i++) {
                dp[0][i]= (i/weight[0]) * profit[0];
        }

        for (int idx = 1; idx < n; idx++) {
            // w range because we keep filling all the possibilities
            for (int cap = 0; cap <= w; cap++) {
                int notPick = dp[idx - 1][cap];

                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= cap) pick = profit[idx] + dp[idx][cap - weight[idx]];
                dp[idx][cap] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][w];
    }

    public static int unboundedKnapsack4(int n, int w, int[] profit, int[] weight) {
        int[] cur = new int[w+1];

        // Filling all the w range with the possibilities of getting max profit in w range wrt weight[0].
        for (int i = weight[0]; i <= w; i++) {
            cur[i]= (i/weight[0]) * profit[0];
        }

        for (int idx = 1; idx < n; idx++) {
            // w range because we keep filling all the possibilities
            for (int cap = 0; cap <= w; cap++) {
                int notPick = cur[cap];

                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= cap) pick = profit[idx] + cur[cap - weight[idx]];
                cur[cap] = Math.max(pick, notPick);
            }
        }

        return cur[w];
    }
}
