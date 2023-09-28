package Leetcode;

public class Print_Longest_Common_Subsequence {
    public static void main(String[] args) {
        System.out.println(lcs("adebc", "dcadb"));
    }

    public static StringBuilder lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        StringBuilder str = new StringBuilder();
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
                if (s.charAt(idx1 - 1) == t.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                } else {
                    int pickL = dp[idx1 - 1][idx2];
                    int pickR = dp[idx1][idx2 - 1];
                    dp[idx1][idx2] = Math.max(pickL, pickR);
                }
            }
        }

        int i = n, j = m;

        while (i > 0 && j > 0){
            if (s.charAt(i-1) == t.charAt(j-1)) {
                str.append(s.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        return str.reverse();
    }
}
