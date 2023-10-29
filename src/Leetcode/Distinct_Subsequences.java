package Leetcode;

import java.util.Arrays;

public class Distinct_Subsequences {
    public static void main(String[] args) {
        System.out.println(distinctSubsequences3("brootgroot", "brt"));
    }
    static int mod = (int)(1e9+7);

    public static int distinctSubsequences(String str, String sub) {
        int n = str.length();
        int m = sub.length();
        return countDistinct(str, n-1, m-1, sub);
    }

    private static int countDistinct(String str, int idx1, int idx2, String sub) {
        if (idx2 < 0) return 1;
        if (idx1 < 0) return 0;

        if (str.charAt(idx1) == sub.charAt(idx2)) {
            int leaveOne = countDistinct(str, idx1 - 1, idx2 - 1, sub);
            int stay = countDistinct(str, idx1 - 1, idx2, sub);
            return (leaveOne + stay) % mod;
        }
        else return countDistinct(str, idx1-1, idx2, sub);
    }

    public static int distinctSubsequences2(String str, String sub) {
        int n = str.length();
        int m = sub.length();

        int[][] dp = new int[n][m];
        for (int[] r: dp){
            Arrays.fill(r, -1);
        }

        return countDistinct2(str, n-1, m-1, sub, dp);
    }

    private static int countDistinct2(String str, int idx1, int idx2, String sub, int[][] dp) {
        if (idx2 < 0) return 1;
        if (idx1 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (str.charAt(idx1) == sub.charAt(idx2)) {
            int leaveOne = countDistinct2(str, idx1 - 1, idx2 - 1, sub,dp);
            int stay = countDistinct2(str, idx1 - 1, idx2, sub,dp);
            return dp[idx1][idx2]= (leaveOne + stay) % mod;
        }
        else return dp[idx1][idx2]= countDistinct2(str, idx1-1, idx2, sub,dp);
    }

    public static int distinctSubsequences3(String str, String sub) {
        int n = str.length();
        int m = sub.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0]=1;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (str.charAt(idx1-1) == sub.charAt(idx2-1)) {
                    int leaveOne = dp[idx1 - 1][idx2 - 1];
                    int stay = dp[idx1 - 1][idx2];
                    dp[idx1][idx2]= (leaveOne + stay) % mod;
                }
                else dp[idx1][idx2]= dp[idx1 - 1][idx2];
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m];
    }
}
