package Leetcode;

import java.util.*;

public class Maximum_sum_of_non_adjacent_elements {

    // With recursion
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        return findMaxsum(n - 1, nums);
    }

    private static int findMaxsum(int n, ArrayList<Integer> nums) {
        if (n == 0) return nums.get(0);
        if (n < 0) return 0;

        int left = nums.get(n) + findMaxsum(n - 2, nums);
        int right = 0 + findMaxsum(n - 1, nums);
        return Math.max(left, right);
    }

    // With dp - Memoization
    public static int maximumNonAdjacentSum2(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findMaxsum2(n - 1, nums, dp);
    }

    private static int findMaxsum2(int n, ArrayList<Integer> nums, int[] dp) {
        if (n == 0) return nums.get(0);
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int left = nums.get(n) + findMaxsum2(n - 2, nums, dp);
        int right = 0 + findMaxsum2(n - 1, nums, dp);
        return dp[n] = Math.max(left, right);
    }

    // With dp - Tabular
    public static int maximumNonAdjacentSum3(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int left = nums.get(i);
            if (i > 1) left += dp[i-2];
            int right = 0 + dp[i-1];
            dp[i] = Math.max(left, right);
        }
        return dp[n-1];
    }

    //  Optimized with O(1) SC
    public static int maximumNonAdjacentSum4(ArrayList<Integer> nums) {
        int n = nums.size();
        int a = nums.get(0), b=nums.get(0), c=0;

        for (int i = 1; i < n; i++) {
            int left = nums.get(i);
            if (i > 1) left += a;
            int right = 0 + b;
            c = Math.max(left, right);
            a=b;
            b=c;
        }
        return b;
    }
}
