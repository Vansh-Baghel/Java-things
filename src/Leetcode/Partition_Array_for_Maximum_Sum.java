package Leetcode;

import java.util.Arrays;

public class Partition_Array_for_Maximum_Sum {
    public static void main(String[] args) {
        int[] nums = {1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(maxSumAfterPartitioning(nums, 4));
    }

    static int maxSumAfterPartitioning(int[] arr, int k) {
        return solve(0, arr.length, arr, k);
    }

    static int solve (int idx, int n, int[] nums, int k){
        if (idx >= n) return 0;

        int res = 0, maxi = 0;

        for (int j = idx; j - idx < k && j < n; j++){
            maxi = Math.max(maxi, nums[j]);
            res = Math.max(res, (maxi * (j - idx + 1)) + solve (j + 1, n, nums, k));
        }

        return res;
    }

    static int maxSumAfterPartitioning2(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve(0, arr.length, arr, k, dp);
    }

    static int solve (int idx, int n, int[] nums, int k, int[] dp){
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int res = 0, maxi = 0;

        for (int j = idx; j - idx < k && j < n; j++){
            maxi = Math.max(maxi, nums[j]);
            res = Math.max(res, (maxi * (j - idx + 1)) + solve (j + 1, n, nums, k, dp));
        }

        return dp[idx] = res;
    }

    static int maxSumAfterPartitioning3(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[arr.length+1];

        int maxi = 0;

        for (int idx = 1; idx <= n; idx++) {
            maxi = 0;
            for (int j = 1; j <= k && idx - j >= 0; j++){
                maxi = Math.max(maxi, arr[idx - j]);
                dp[idx] = Math.max(dp[idx], (maxi * j) + dp[idx - j]);
            }
        }

        return dp[n];
    }

    public int maxSumAfterPartitioning4(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[arr.length+1];

        int maxi = 0;

        for (int idx = n - 1; idx >= 0; idx--) {
            maxi = 0;
            for (int j = idx; j - idx < k && j < n; j++){
                maxi = Math.max(maxi, arr[j]);
                dp[idx] = Math.max(dp[idx], (maxi * (j - idx + 1)) + dp[j + 1]);
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[0];
    }
}
