package Leetcode;

import java.util.Arrays;

public class Wildcard_string_matching {
    static boolean match(String wild, String pattern){
        int n = pattern.length(), m = wild.length();
        return doesMatch(n - 1, m - 1, pattern, wild);
    }

    private static boolean doesMatch(int idx1, int idx2, String pattern, String wild) {
        if (idx1 == 0 && idx2 == 0) return pattern.charAt(idx1) == wild.charAt(idx2) || wild.charAt(idx2) == '*' || wild.charAt(idx2) == '?';

        if (idx1 < 0 || idx2 < 0) return false;

        boolean notPick = false;
        boolean pick = false;

        if (pattern.charAt(idx1) == wild.charAt(idx2) || wild.charAt(idx2) == '?') pick = doesMatch(idx1 - 1, idx2 - 1, pattern, wild);
        else if (wild.charAt(idx2) == '*'){
            pick = doesMatch(idx1 - 1, idx2 - 1, pattern, wild);
            notPick = doesMatch(idx1 - 1, idx2, pattern, wild);
            // Doesnt match condition
        } else return false;

        return pick || notPick;
    }

    static boolean match2(String wild, String pattern){
        int n = pattern.length(), m = wild.length();
        int[][] dp = new int[n][m];

        for (int[] r: dp) Arrays.fill(r, -1);

        return doesMatch(n - 1, m - 1, pattern, wild, dp);
    }

    private static boolean doesMatch(int idx1, int idx2, String pattern, String wild, int[][] dp) {
        if (idx1 == 0 && idx2 == 0)
            return pattern.charAt(idx1) == wild.charAt(idx2) || wild.charAt(idx2) == '*' || wild.charAt(idx2) == '?';

        if (idx1 < 0 || idx2 < 0) return false;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2] == 1;

        boolean notPick = false;
        boolean pick = false;

        if (pattern.charAt(idx1) == wild.charAt(idx2) || wild.charAt(idx2) == '?')
            pick = doesMatch(idx1 - 1, idx2 - 1, pattern, wild, dp);
        else if (wild.charAt(idx2) == '*') {
            pick = doesMatch(idx1 - 1, idx2 - 1, pattern, wild, dp);
            notPick = doesMatch(idx1 - 1, idx2, pattern, wild, dp);
            // Doesnt match condition
        } else {
            dp[idx1][idx2] = 0;
            return false;
        }

        boolean res = pick || notPick;

        dp[idx1][idx2] = res ? 1 : 0;

        return res;
    }
}
