package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Printing_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8,21};
        System.out.println(printingLongestIncreasingSubsequence(arr));
    }
    public static int printingLongestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int lastIdx = 0;

        int[] dp = new int[n];
        int[] hash2 = new int[n];
        int maxi = 0;

        Arrays.fill(dp, 1);

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (dp[idx] < 1 + dp[prev] && arr[prev] < arr[idx]) {
                    dp[idx] = Math.max(1 + dp[prev], dp[idx]);
                    hash2[idx] = prev;
                }
            }
            if (dp[idx] > maxi){
                maxi = dp[idx];
                lastIdx = idx;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIdx]);

        while (hash2[lastIdx] != lastIdx){
            lastIdx = hash2[lastIdx];
            ans.add(arr[lastIdx]);
        }

        Collections.reverse(ans);
        System.out.println(ans);

        return maxi;
    }
}
