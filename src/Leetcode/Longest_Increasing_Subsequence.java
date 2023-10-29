package Leetcode;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 11, 1, 16, 8};
        System.out.println(longestIncreasingSubsequence(numbers));
    }
    static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        return maxCount(arr, 0,-1, n-1);
    }

    private static int maxCount(int[] arr, int idx, int prev_idx, int n) {
        if (idx == n) return 0;

        int notPick = maxCount(arr, idx+1, prev_idx, n);
        int pick = Integer.MIN_VALUE;
        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            pick = 1 + maxCount(arr, idx + 1, idx, n);
        }
        return Math.max(notPick, pick);
    }

    static int longestIncreasingSubsequence2(int arr[]) {
        int n = arr.length;

        int[][] dp = new int[n][n+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxCount(arr, 0,-1, n-1, dp);
    }

    private static int maxCount(int[] arr, int idx, int prev_idx, int n, int[][] dp) {
        if (idx == n) return 0;

        if (dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];

        int notPick = maxCount(arr, idx+1, prev_idx, n, dp);
        int pick = Integer.MIN_VALUE;
        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            pick = 1 + maxCount(arr, idx + 1, idx, n, dp);
        }
        return dp[idx][prev_idx+1] = Math.max(notPick, pick);
    }

    public static int longestIncreasingSubsequence3(int arr[]) {
        int n = arr.length;

        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 0;

        Arrays.fill(dp, 1);

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (arr[prev] < arr[idx]) {
                    dp[idx] = Math.max(1 + dp[prev], dp[idx]);
                    hash[idx] = prev;
                }
            }
            maxi = Math.max(dp[idx], maxi);
        }
        return maxi;
    }
}
