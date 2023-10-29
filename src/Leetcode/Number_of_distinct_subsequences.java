package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Number_of_distinct_subsequences {
    public static void main(String[] args) {
        System.out.println(distinctSubsequences("mtuukaq"));
    }

    static int distinctSubsequences(String S) {
        int n = S.length();
        int[] dp = new int[n+1];
        int mod = (int)(1e9 + 7);
        HashMap<Character, Integer> hm = new HashMap<>();
        // Since we are also consider "" as a subsequence.
        dp[0]=1;

        for (int i = 1; i <= n; i++) {
            char ch = S.charAt(i-1);

            dp[i] = (2 * dp[i-1]) % mod;
            if (hm.containsKey(ch)) dp[i] = (dp[i] - dp[hm.get(ch)-1] + mod) % mod;
            hm.put(ch, i);
        }
        return dp[n];
    }
}
