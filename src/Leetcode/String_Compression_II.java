package Leetcode;

import java.util.Arrays;

public class String_Compression_II {
    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("", 2));
    }
    static int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        char ch = 0;
        return minLength(n - 1, ch, 0, k, s);
    }

    private static int minLength(int idx, char prev, int freq, int k, String s) {
        if (k < 0) return 100000;
        if (idx < 0) return 0;

        int delete = minLength(idx - 1, prev, freq, k - 1, s);
        int pick;

        if (prev != s.charAt(idx)){
            pick = 1 + minLength(idx - 1, s.charAt(idx), 1, k, s);
        } else {
            int oneMoreAddition = 0;
            if (freq == 1 || freq == 9 || freq == 99) {
                oneMoreAddition = 1;
            }
            pick = oneMoreAddition + minLength(idx - 1, s.charAt(idx), freq + 1, k, s);
        }

        return Math.min(pick, delete);
    }

    static int[][][][] dp = new int[101][27][101][101];

    static int getLengthOfOptimalCompression2(String s, int k) {
        int n = s.length();

        for(int[][][] subDp: dp){
            for (int[][] subSubdp: subDp){
                for (int[] r: subSubdp) Arrays.fill(r, -1);
            }
        }

        return minLength(n - 1, 26, 0, k, s, dp);
    }

    private static int minLength(int idx, int prev, int freq, int k, String s, int[][][][] dp) {
        if (k < 0) return 100000;
        if (idx < 0) return 0;

        if (dp[idx][prev][freq][k] != -1) return dp[idx][prev][freq][k];

        int delete = minLength(idx - 1, prev, freq, k - 1, s, dp);
        int pick;

        if (prev != s.charAt(idx) - 'a'){
            pick = 1 + minLength(idx - 1, s.charAt(idx) - 'a', 1, k, s, dp);
        } else {
            int oneMoreAddition = 0;
            if (freq == 1 || freq == 9 || freq == 99) {
                oneMoreAddition = 1;
            }
            pick = oneMoreAddition + minLength(idx - 1, s.charAt(idx) - 'a', freq + 1, k, s, dp);
        }

        return dp[idx][prev][freq][k] = Math.min(pick, delete);
    }
}
