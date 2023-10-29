package Leetcode;

import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        System.out.println(editDistance2("abc", "dc"));
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return getMinSteps(n-1, m-1, str1, str2, dp);
    }

    private static int getMinSteps(int idx1, int idx2, String str1, String str2, int[][] dp) {
        if (idx1 < 0) return idx2 + 1;
        if (idx2 < 0) return idx1 + 1;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (str1.charAt(idx1) == str2.charAt(idx2)) return dp[idx1][idx2] = getMinSteps(idx1 - 1, idx2- 1, str1, str2, dp);

        else {
            int replace = 1 + getMinSteps(idx1 - 1, idx2- 1, str1, str2, dp);
            int insert = 1 + getMinSteps(idx1, idx2- 1, str1, str2, dp);
            int delete = 1 + getMinSteps(idx1 - 1, idx2, str1, str2, dp);

            return dp[idx1][idx2] = Math.min(replace, Math.min(insert, delete));
        }
    }

    public static int editDistance2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0]=i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i]=i;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) dp[idx1][idx2]= dp[idx1-1][idx2-1];
                else {
                    int replace = 1 + dp[idx1 - 1][idx2-1];
                    int insert = 1 + dp[idx1][idx2-1];
                    int delete = 1 + dp[idx1-1][idx2];

                    dp[idx1][idx2]=Math.min(replace, Math.min(insert, delete));
                }
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
