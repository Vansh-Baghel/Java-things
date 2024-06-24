package Leetcode;

import java.util.*;

public class Word_Break {
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");

        System.out.println(wordBreak("catsandog", wordDict));
    }

    static HashSet<String> hs = new HashSet<>();

    static boolean wordBreak(String s, List<String> wordDict) {
        int idx = 0, n = s.length();

        hs.addAll(wordDict);
        return solve(idx, s, n);
    }

    static boolean solve(int idx, String s, int n) {
        if (idx >= n) return true;
        if (hs.contains(s)) return true;

        String str = "";
        for (int len = idx; len <= n; len++) {
            str = s.substring(idx, len);

            if (hs.contains(str) && solve(len, s, n)){
                return true;
            }
        }

        return false;
    }

    static boolean wordBreak2(String s, List<String> wordDict) {
        int idx = 0, n = s.length();

        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);

        hs.addAll(wordDict);
        return solve(idx, s, n, dp);
    }

    static boolean solve(int idx, String s, int n, boolean[] dp) {
        if (idx >= n) return true;
        if (hs.contains(s)) return true;

        if (!dp[idx]) return true;

        String str = "";
        for (int len = idx; len <= n; len++) {
            str = s.substring(idx, len);

            if (hs.contains(str) && solve(len, s, n, dp)){
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}
