package Leetcode;

import java.util.Arrays;

public class Gold_Mine_Problem {
    static int maxGold(int n, int m, int M[][]){
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(getMax(i, 0, n, m, M), maxi);
        }

        return maxi;
    }

    private static int getMax(int idx1, int idx2, int n, int m, int[][] mat) {
        if (idx1 < 0 || idx2 < 0 || idx1 >= n || idx2 >= m) return 0;

        if (idx1 == n - 1 || idx2 == m - 1) return mat[idx1][idx2];

        int upRight = getMax(idx1 - 1, idx2 + 1, n, m, mat);
        int right = getMax(idx1, idx2 + 1, n, m, mat);
        int downRight = getMax(idx1 + 1, idx2 + 1, n, m, mat);

        return mat[idx1][idx2] + Math.max(right, Math.max(downRight, upRight));
    }

    static int maxGold2(int n, int m, int M[][]){
        int maxi = -1;
        int[][] dp = new int[n][m];
        for (int[] r: dp) Arrays.fill(r, -1);

        for (int i = 0; i < n; i++) {
            maxi = Math.max(getMax(i, 0, n, m, M, dp), maxi);
        }

        return maxi;
    }

    private static int getMax(int idx1, int idx2, int n, int m, int[][] mat, int[][] dp) {
        if (idx1 < 0 || idx2 < 0 || idx1 >= n || idx2 >= m) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int upRight = getMax(idx1 - 1, idx2 + 1, n, m, mat, dp);
        int right = getMax(idx1, idx2 + 1, n, m, mat, dp);
        int downRight = getMax(idx1 + 1, idx2 + 1, n, m, mat, dp);

        return dp[idx1][idx2] = mat[idx1][idx2] + Math.max(right, Math.max(downRight, upRight));
    }
}
