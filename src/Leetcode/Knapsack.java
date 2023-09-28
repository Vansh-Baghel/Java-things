package Leetcode;

import java.util.Arrays;

public class Knapsack {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return countMax(weight, value, n-1, maxWeight);
    }

    static int countMax(int[] weight, int[] value, int idx, int maxWeight){
        if (maxWeight < 0) return 0;
        if(idx == 0){
            if(weight[0] <= maxWeight) return value[0];
            return 0;
        }

        int notPick = countMax(weight, value, idx-1, maxWeight);
        int pick = Integer.MIN_VALUE;
        if (weight[idx] <= maxWeight) pick = value[idx] + countMax(weight, value, idx-1, maxWeight-weight[idx]);

        return Math.max(pick, notPick);
    }

    static int knapsack2(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][]=new int[n][maxWeight+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countMax2(weight, value, n-1, maxWeight, dp);
    }

    static int countMax2(int[] weight, int[] value, int idx, int maxWeight, int[][] dp){
        if (maxWeight < 0) return 0;

        if(idx == 0){
            if(weight[0] <= maxWeight) return value[0];
            return 0;
        }

        if(dp[idx][maxWeight]!=-1) return dp[idx][maxWeight];

        int pick = Integer.MIN_VALUE;
        if (weight[idx] <= maxWeight) pick = value[idx] + countMax2(weight, value, idx-1, maxWeight-weight[idx], dp);
        int notPick = countMax2(weight, value, idx-1, maxWeight, dp);

        return dp[idx][maxWeight] = Math.max(pick, notPick);
    }

    static int knapsack3(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp =new int[n][maxWeight+1];
        for(int i=weight[0]; i<=maxWeight; i++){
            dp[0][i] = value[0];
        }

        for (int idx = 1; idx < n; idx++) {
            // value mai 0 kabhi h hee nhi, so start from 1, and also maxWeight is starting from 1.
            for (int k = 1; k <= maxWeight; k++) {
                int notPick = dp[idx-1][k];
                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= k) pick = value[idx] + dp[idx-1][k-weight[idx]];

                dp[idx][k] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int knapsack4(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for(int i=weight[0]; i<=maxWeight; i++){
            prev[i] = value[0];
        }

        for (int idx = 1; idx < n; idx++) {
            // value mai 0 kabhi h hee nhi, so start from 1, and also maxWeight is starting from 1.
            for (int k = maxWeight; k >= 0; k--) {
                int notPick = prev[k];
                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= k) pick = value[idx] + prev[k-weight[idx]];

                prev[k] = Math.max(pick, notPick);
            }
        }
        return prev[maxWeight];
    }
}
