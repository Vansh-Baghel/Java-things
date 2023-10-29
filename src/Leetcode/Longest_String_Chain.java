package Leetcode;

import java.util.*;

public class Longest_String_Chain {
    public static void main(String[] args) {
        String[] arr = {"x", "xx", "y", "xyx"};
        System.out.println(longestStrChain(arr));
    }
    public static int longestStrChain(String[] arr) {
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);

        Arrays.sort(arr, lengthComparator);

        int n = arr.length, maxi=0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (checkCombination(arr[prev] , arr[idx]) && dp[prev] + 1 > dp[idx]){
                    dp[idx] = dp[prev] + 1;
                }
            }
            maxi = Math.max(maxi, dp[idx]);
        }

        return maxi;
    }

    private static boolean checkCombination(String s, String s1) {
        if (s.length() + 1 != s1.length()) return false;

        int i = 0, j = 0;

        while (j < s1.length()){
            if (i < s.length() && s.charAt(i) == s1.charAt(j)) {
                i++;
            }
            j++;
        }

        return s.length() == i && s1.length() == j;
    }
}
