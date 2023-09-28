package Leetcode;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbdb"));
    }

    static int longestPalindromeSubseq(String s) {
        StringBuilder reversed = new StringBuilder(s);
        String reversedStr = reversed.reverse().toString();

        return lcs(s,reversedStr);
    }
    public static int lcs(String s, String t) {
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

        return dp[n][m];
    }
}
