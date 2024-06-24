package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("psnw", "vozsh"));
    }
    public static int lcs(String s, String t) {
        return lcs3(s, t);
    }

    private static int getLCS(String s, String t, int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0) return 0;

        if (s.charAt(idx1) == t.charAt(idx2)) return 1 + getLCS(s,t,idx1-1, idx2-1);

        int pickL = getLCS(s,t,idx1-1, idx2);
        int pickR = getLCS(s,t,idx1, idx2-1);
        return Math.max(pickL, pickR);
    }

    public static int lcs2(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] r: dp) Arrays.fill(r, -1);

        return getLCS2(s, t, n - 1, m-1, dp);
    }

    private static int getLCS2(String s, String t, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (s.charAt(idx1) == t.charAt(idx2)) return 1 + getLCS2(s,t,idx1-1, idx2-1, dp);

        int pickL = getLCS2(s,t,idx1-1, idx2, dp);
        int pickR = getLCS2(s,t,idx1, idx2-1, dp);
        return dp[idx1][idx2] = Math.max(pickL, pickR);
    }

    public static int lcs3(String s, String t) {
        int n = s.length();
        int m = t.length();
        // We are right shifting the integers like n is treated as n - 1. Because our base condition is if idx < 0, and dp ka index cannot be negative like dp[-1][0], it will return out of bound. Therefore taking n + 1.

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (s.charAt(idx1 - 1) == t.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                else {
                    int pickL = dp[idx1 - 1][idx2];
                    int pickR = dp[idx1][idx2 - 1];
                    dp[idx1][idx2] = Math.max(pickL, pickR);
                }
            }
        }

        for(int[] row: dp){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }

        return dp[n][m];
    }









    static int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length(), n = text1.length();
        return subseqCount(n - 1,m - 1,text1,text2);
    }

    private static int subseqCount(int idx1, int idx2, String text1, String text2) {
        if (idx1 < 0 || idx2 < 0) return 0;
        if (text1.charAt(idx1) == text2.charAt(idx2)) return 1 + subseqCount(idx1 - 1, idx2 - 1, text1, text2);

        int t1 = subseqCount(idx1 - 1, idx2, text1, text2);
        int t2 = subseqCount(idx1, idx2 - 1, text1, text2);

        return Math.max(t1, t2);
    }

    static int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] r: dp) Arrays.fill(r, -1);
        return subseqCount(n - 1,m - 1,text1,text2, dp);
    }

    private static int subseqCount(int idx1, int idx2, String text1, String text2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;
        if (text1.charAt(idx1) == text2.charAt(idx2)) return 1 + subseqCount(idx1 - 1, idx2 - 1, text1, text2, dp);

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int t1 = subseqCount(idx1 - 1, idx2, text1, text2, dp);
        int t2 = subseqCount(idx1, idx2 - 1, text1, text2, dp);

        return dp[idx1][idx2] = Math.max(t1, t2);
    }

    static int longestCommonSubsequence3(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                else {
                    int t1 = dp[idx1 - 1][idx2];
                    int t2 = dp[idx1][idx2 - 1];

                    dp[idx1][idx2] = Math.max(t1, t2);
                }
            }
        }

        return dp[n][m];
    }
}
