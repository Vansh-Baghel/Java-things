package Leetcode;

import java.util.Arrays;

public class Decode_Ways {
    static int numDecodings(String s) {
        int n = s.length();
        return totalWays(0, n, s);
    }

    private static int totalWays(int idx, int n, String s) {
        if (idx < n && s.charAt(idx) == '0') return 0;
        else if (idx >= n - 1) return 1;
        else if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) >= 48 && s.charAt(idx + 1) <= 54)) return totalWays(idx + 1, n, s) + totalWays(idx + 2, n, s);
        else return totalWays(idx+1, n, s);
    }

    static int numDecodings2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return totalWays(0, n, s, dp);
    }

    private static int totalWays(int idx, int n, String s, int[] dp) {
        if (idx < n && s.charAt(idx) == '0') return 0;
        else if (idx >= n - 1) return 1;

        if (dp[idx] != -1) return dp[idx];

        // Taking 2 indices at the same time only for nums starting with 1 (10,11,--,19) or 2 (20, 21,--,26). Else take 1 nums at a time otherwise out of range hojayega.
        else if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) >= 48 && s.charAt(idx + 1) <= 54)) return dp[idx] = totalWays(idx + 1, n, s, dp) + totalWays(idx + 2, n, s, dp);
        else return dp[idx] = totalWays(idx+1, n, s, dp);
    }
}
