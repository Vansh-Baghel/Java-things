package Leetcode;

import java.util.Arrays;

public class LCS_of_three_strings {
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1+1][n2+1][n3+1];

        for (int[][] r: dp){
            for (int[] c: r){
                Arrays.fill(c, -1);
            }
        }

        return solve(0, 0, 0, n1, n2, n3, A, B, C, dp);
    }

    static int solve (int idx1, int idx2, int idx3, int n1, int n2, int n3, String text1, String text2, String text3, int[][][] dp){
        if (idx1 > n1 || idx2 > n2 || idx3 > n3) return 0;

        if (dp[idx1][idx2][idx3] != -1) return dp[idx1][idx2][idx3];

        if (text1.charAt(idx1) == text2.charAt(idx2) && text2.charAt(idx2) == text3.charAt(idx3)) return 1 + solve(idx1 + 1, idx2 + 1, idx3 + 1, n1, n2, n3, text1, text2, text3, dp);

        int moveText1 = solve(idx1 + 1, idx2, idx3, n1, n2, n3, text1, text2, text3, dp);
        int moveText2 = solve(idx1, idx2 + 1, idx3, n1, n2, n3, text1, text2, text3, dp);
        int moveText3 = solve(idx1, idx2, idx3 + 1, n1, n2, n3, text1, text2, text3, dp);

        return dp[idx1][idx2][idx3] = Math.max(moveText1, Math.max(moveText2, moveText3));
    }
}
