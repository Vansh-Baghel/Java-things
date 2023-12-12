package Leetcode;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs3(cost));
    }

    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(totalCost(n - 1, cost), totalCost(n - 2, cost));
    }

    private static int totalCost(int idx, int[] cost) {
        if (idx < 0) return 0;

        if (idx <= 1) return cost[idx];

        int pick1 = totalCost(idx - 1, cost);
        int pick2 = totalCost(idx - 2, cost);

        return cost[idx] + Math.min(pick1, pick2);
    }

    static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return Math.min(totalCost(n-1, cost, dp), totalCost(n-2, cost, dp));
    }

    private static int totalCost(int idx, int[] cost, int[] dp) {
        if (idx < 0) return 0;
        if (idx <= 1) return cost[idx];

        if (dp[idx] != -1) return dp[idx];

        int pick1 = totalCost(idx - 1, cost, dp);
        int pick2 = totalCost(idx - 2, cost, dp);

        return dp[idx] = cost[idx] + Math.min(pick1, pick2);
    }

    static int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}
