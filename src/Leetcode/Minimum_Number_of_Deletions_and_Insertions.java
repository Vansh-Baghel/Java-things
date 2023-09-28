package Leetcode;

public class Minimum_Number_of_Deletions_and_Insertions {
    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int lcs = lcs(s1, s2);
        int deletions = s1.length() - lcs;
        int insertions = s2.length() - lcs;

        return deletions + insertions;
    }

    private static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // str2 is just reverse, so size is same
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
                else {
                    int pick = dp[idx1 - 1][idx2];
                    int notPick = dp[idx1][idx2 - 1];
                    dp[idx1][idx2] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][m];
    }
}
