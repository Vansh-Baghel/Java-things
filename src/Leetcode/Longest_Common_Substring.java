package Leetcode;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        System.out.println(lcs("abcde", "abcxe"));
    }

    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int ans = 0;
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
                if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                ans = Math.max(ans, dp[idx1][idx2]);
            }
        }

        return ans;
    }
}
