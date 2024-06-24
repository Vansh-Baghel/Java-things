package Leetcode;

import java.util.Arrays;

public class Jump_Game_II {
    static int jump(int[] nums) {
        int n = nums.length;
        return getMinSteps(0, n - 1, nums);
    }

    private static int getMinSteps(int idx, int n, int[] nums) {
        if (idx >= n) return 0;

        int res = 10001;

        for (int i = idx + 1; i <= idx + nums[idx]; i++) {
            res = Math.min(res, 1 + getMinSteps(i, n, nums));
        }

        return res;
    }

    static int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMinSteps(0, n - 1, nums, dp);
    }

    private static int getMinSteps(int idx, int n, int[] nums, int[] dp) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int res = 10001;

        for (int i = idx + 1; i <= idx + nums[idx]; i++) {
            res = Math.min(res, 1 + getMinSteps(i, n, nums, dp));
        }

        return dp[idx] = res;
    }
}
