package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cost_to_Cut_a_Chocolate {
    public static void main(String[] args) {
        int[] cuts = {1,3};
        int c = cuts.length;
        System.out.println(cost3(4, c, cuts));
    }

    static int cost(int n, int c, int cuts[]) {
        List<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        for(int cut: cuts) cutList.add(cut);

        Collections.sort(cutList);
        cutList.add(n);

        int[] cutsArr = new int[cutList.size()];

        for (int i = 0; i < cutList.size(); i++) {
            cutsArr[i] = cutList.get(i);
        }
        return minCost(1,c,cutsArr);
    }

    static int minCost(int idx, int j, int[] cuts) {
        if (idx > j) return 0;
        int mini = Integer.MAX_VALUE;

        for (int i = idx; i <= j; i++) {
            int cost = cuts[j+1] - cuts[idx - 1] + minCost(idx, i - 1, cuts) + minCost(i + 1, j, cuts);
            mini = Integer.min(mini, cost);
        }

        return mini;
    }

    static int cost2(int n, int c, int cuts[]) {
        List<Integer> cutList = new ArrayList<>();
        cutList.add(0);

        int[][] dp = new int[c+1][c+1];
        for (int[] r : dp) Arrays.fill(r, -1);

        for(int cut: cuts) cutList.add(cut);

        Collections.sort(cutList);
        cutList.add(n);

        int[] cutsArr = new int[cutList.size()];

        for (int i = 0; i < cutList.size(); i++) {
            cutsArr[i] = cutList.get(i);
        }
        return minCost(1,c,cutsArr, dp);
    }

    static int minCost(int idx, int j, int[] cuts, int[][] dp) {
        if (idx > j) return 0;

        if (dp[idx][j] != -1) return dp[idx][j];

        int mini = Integer.MAX_VALUE;

        for (int i = idx; i <= j; i++) {
            int cost = cuts[j+1] - cuts[idx - 1] + minCost(idx, i - 1, cuts, dp) + minCost(i + 1, j, cuts, dp);
            mini = Integer.min(mini, cost);
        }

        return dp[idx][j] = mini;
    }

    static int cost3(int n, int c, int cuts[]) {
        List<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        cutList.add(n);

        for(int cut: cuts) cutList.add(cut);

        Collections.sort(cutList);

        int[] cutsArr = new int[cutList.size()];

        int[][] dp = new int[c+2][c+2];

        for (int i = 0; i < cutList.size(); i++) {
            cutsArr[i] = cutList.get(i);
        }

        for (int idx = c; idx >= 1; idx--) {
            for (int j = 1; j <= c; j++) {
                if (idx > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int i = idx; i <= j; i++) {
                    int cost = cutsArr[j+1] - cutsArr[idx - 1] + dp[idx][i - 1] + dp[i + 1][j];
                    mini = Integer.min(mini, cost);
                }
                dp[idx][j] = mini;
            }
        }

        return dp[1][c];
    }
}
