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








    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return maxSeq(0, -1, n, nums);
    }

    private int maxSeq(int idx, int prevIdx, int n, int[] nums) {
        if (idx == n) return 0;

        int take = 0, skip = 0;

        for (int i = idx; i < n; i++) {
            if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                take = 1 + maxSeq(idx+1, idx, n, nums);
            }
            skip = maxSeq(idx+1, prevIdx, n, nums);
        }

        return Math.max(skip, take);
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxSeq(0, -1, n, nums, dp);
    }

    private int maxSeq(int idx, int prevIdx, int n, int[] nums, int[][] dp) {
        if (idx == n) return 0;

        if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];

        int take = 0, skip = 0;

        for (int i = idx; i < n; i++) {
            if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                take = 1 + maxSeq(idx+1, idx, n, nums, dp);
            }
            skip = maxSeq(idx+1, prevIdx, n, nums, dp);
        }

        return dp[idx][prevIdx + 1] = Math.max(skip, take);
    }


    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int take = 0, skip = 0;

                if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                    take = 1 + dp[idx+1][idx + 1];
                }
                skip = dp[idx+1][prevIdx + 1];
                dp[idx][prevIdx + 1] = Math.max(skip, take);
            }
        }

        return dp[0][-1+1];
    }

    public int lengthOfLIS4(int[] nums) {
        int n = nums.length;
        int[] cur = new int[n+1];
        int[] nxt = new int[n+1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int take = 0, skip = 0;

                if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                    take = 1 + nxt[idx + 1];
                }
                skip = nxt[prevIdx + 1];
                cur[prevIdx + 1] = Math.max(skip, take);
            }
            nxt = cur;
        }

        return cur[0];
    }
}
