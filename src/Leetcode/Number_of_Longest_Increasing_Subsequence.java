package Leetcode;

import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {50,3,90,60,80};
        System.out.println(findNumberOfLIS(arr));
    }

    static int findNumberOfLIS(int []arr) {
        int maxi = 0;
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (arr[prev] < arr[idx] && dp[prev] + 1 > dp[idx]){
                    dp[idx] = dp[prev] + 1;
                    cnt[idx]=cnt[prev]+cnt[idx];
                } else if(arr[prev] < arr[idx] && dp[idx] == dp[prev] + 1) {
                    cnt[idx]=cnt[prev];
                }
            }
            maxi=Math.max(maxi, dp[idx]);
        }

        return maxi;
    }
}
