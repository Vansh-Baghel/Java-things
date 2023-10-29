package Leetcode;

import java.util.Arrays;

public class Wildcard_Matching {
    public static void main(String[] args) {
        System.out.println(wildcardMatching3("ab*", "ab"));
    }

    public static boolean wildcardMatching(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        return isMatching(n-1,m-1,pattern,text);
    }

    private static boolean isMatching(int idx1, int idx2, String pattern, String text) {
        if (idx1 < 0 && idx2 < 0) return true;
        if (idx1 < 0 && idx2 >= 0) return false;
        if (idx2 < 0 && idx1 >= 0) return isAllStars(pattern, idx1);

        if (pattern.charAt(idx1) == text.charAt(idx2) || pattern.charAt(idx1) == '?') return isMatching(idx1-1, idx2-1, pattern, text);
        else{
            if (pattern.charAt(idx1) == '*'){
                boolean pick = isMatching(idx1-1, idx2, pattern, text);
                boolean notPick = isMatching(idx1, idx2-1, pattern, text);
                return pick || notPick;
            } else return false;
        }
    }

        static boolean isAllStars(String S1, int i) {
            for (int j = 0; j <= i; j++) {
                if (S1.charAt(j) != '*')
                    return false;
            }
            return true;
        }

    public static boolean wildcardMatching2(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();

        int[][] dp = new int[n][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return isMatching2(n-1,m-1,pattern,text, dp) == 1;
    }

    private static int isMatching2(int idx1, int idx2, String pattern, String text, int[][] dp) {
        if (idx1 < 0 && idx2 < 0) return 1;
        if (idx1 < 0 && idx2 >= 0) return 0;
        if (idx2 < 0 && idx1 >= 0) return isAllStars(pattern, idx1) ? 1 : 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (pattern.charAt(idx1) == text.charAt(idx2) || pattern.charAt(idx1) == '?')
            return dp[idx1][idx2] = isMatching2(idx1 - 1, idx2 - 1, pattern, text, dp);
        else {
            if (pattern.charAt(idx1) == '*') {
                int pick = isMatching2(idx1 - 1, idx2, pattern, text, dp);
                int notPick = isMatching2(idx1, idx2 - 1, pattern, text, dp);
                return (pick == 1 || notPick == 1) ? 1 : 0;
            } else return 0;
        }
    }

    public static boolean wildcardMatching3(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();

        int[][] dp = new int[n+1][m+1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars2(pattern, i) ? 1 : 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (pattern.charAt(idx1-1) == text.charAt(idx2-1) || pattern.charAt(idx1-1) == '?')
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1];
                else {
                    if (pattern.charAt(idx1-1) == '*') {
                        int pick = dp[idx1 - 1][idx2];
                        int notPick = dp[idx1][idx2 - 1];
                        dp[idx1][idx2] = pick == 1 || notPick == 1 ? 1 : 0;
                    } else dp[idx1][idx2] = 0;
                }
            }
        }
        return dp[n][m] == 1;
    }

    static boolean isAllStars2(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }
}
