package Leetcode;

import java.util.HashSet;

public class Shortest_Common_Supersequence {
    public static void main(String[] args) {
        System.out.println(shortestSupersequence("brute", "groot"));
    }
    public static String shortestSupersequence(String a, String b) {
        // Write your code here.
        StringBuilder ans = new StringBuilder();
        String lcsStr = lcs(a, b, ans);
//        HashSet<Character> hs = new HashSet<>();
//
//        for (char ch: lcsStr.toCharArray()){
//            hs.add(ch);
//        }
//
//        for (char ch: a.toCharArray()){
//            if (!hs.contains(ch)) ans.append(ch);
//        }
//
//        for (char ch: b.toCharArray()){
//            if (!hs.contains(ch)) ans.append(ch);
//        }

        return ans.toString();
    }

    private static String lcs(String str1, String str2, StringBuilder ans) {
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

        int idx1 = n;
        int idx2 = m;

        while (idx1 > 0 && idx2 > 0){
            if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1)) {
                ans.append(str1.charAt(idx1 - 1));
                idx1--;
                idx2--;
            } else if (dp[idx1-1][idx2] > dp[idx1][idx2-1]) {
                ans.append(str1.charAt(idx1 - 1));
                idx1--;
            }
            else {
                ans.append(str2.charAt(idx2 - 1));
                idx2--;
            }
        }

        while (idx1 > 0) {
            ans.append(str1.charAt(idx1 - 1));
            idx1--;
        }
        while (idx2 > 0) {
            ans.append(str2.charAt(idx2 - 1));
            idx2--;
        }

        return ans.reverse().toString();
    }
}
