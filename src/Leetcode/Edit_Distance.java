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










    static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        return minOperations(n - 1, m - 1, word1, word2);
    }

    private static int minOperations(int idx1, int idx2, String word1, String word2) {
        if (idx1 < 0) return idx2 + 1;
        if (idx2 < 0) return idx1 + 1;

        int totalOp = 0;

        if (word1.charAt(idx1) == word2.charAt(idx2)){
            totalOp = minOperations(idx1 - 1, idx2 - 1, word1, word2);
        } else {
            int insert = 1 + minOperations(idx1, idx2 - 1, word1, word2);
            int del = 1 + minOperations(idx1 - 1, idx2, word1, word2);
            int update = 1 + minOperations(idx1 - 1, idx2 - 1, word1, word2);

            totalOp = Math.min(del, Math.min(insert, update));
        }

        return totalOp;
    }

    static int minDistance2(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] r: dp) Arrays.fill(r, -1);
        return minOperations2(n - 1, m - 1, word1, word2, dp);
    }

    private static int minOperations2(int idx1, int idx2, String word1, String word2, int[][] dp) {
        if (idx1 < 0) return idx2 + 1;
        if (idx2 < 0) return idx1 + 1;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int totalOp = 0;

        if (word1.charAt(idx1) == word2.charAt(idx2)){
            totalOp = minOperations2(idx1 - 1, idx2 - 1, word1, word2, dp);
        } else {
            int insert = 1 + minOperations2(idx1, idx2 - 1, word1, word2, dp);
            int del = 1 + minOperations2(idx1 - 1, idx2, word1, word2, dp);
            int update = 1 + minOperations2(idx1 - 1, idx2 - 1, word1, word2, dp);

            totalOp = Math.min(del, Math.min(insert, update));
        }

        return dp[idx1][idx2] = totalOp;
    }

    static int minDistance3(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                int totalOp = 0;

                if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)){
                    totalOp = dp[idx1 - 1][idx2 - 1];
                } else {
                    int insert = 1 + dp[idx1][idx2 - 1];
                    int del = 1 + dp[idx1 - 1][idx2];
                    int update = 1 + dp[idx1 - 1][idx2 - 1];

                    totalOp = Math.min(del, Math.min(insert, update));
                }

                dp[idx1][idx2] = totalOp;
            }
        }

        return dp[n][m];
    }

    static int minDistance4(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                int totalOp = 0;

                if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)){
                    totalOp = dp[idx1 - 1][idx2 - 1];
                } else {
                    int insert = 1 + dp[idx1][idx2 - 1];
                    int del = 1 + dp[idx1 - 1][idx2];
                    int update = 1 + dp[idx1 - 1][idx2 - 1];

                    totalOp = Math.min(del, Math.min(insert, update));
                }

                dp[idx1][idx2] = totalOp;
            }
        }
//        Java, Python, C, TypeScript, After Effects/Figma for UI/UX
        return dp[n][m];
    }
}
