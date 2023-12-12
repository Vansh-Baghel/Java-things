//https://leetcode.com/problems/house-robber/
package Leetcode;

import java.util.Arrays;

public class House_Robber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] newArr = new int[nums.length + 1];

        newArr[0] = 0;
        newArr[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
//           If nums is [1,2,3,1,2] then newArr = [0,1,2,4,4,6] . We are comparing the nums ke num with the addition of curNum + newArr[prevNum] with the newArr[curNum] as new[curNum] is the max num at any point.
            newArr[i + 1] = Math.max(newArr[i] , newArr[i - 1] + nums[i]);
        }

        return newArr[nums.length];
    }

    static int rob2(int[] nums) {
        int n = nums.length;
        return maximumMoneyRobbed(n - 1, nums);
    }

    private static int maximumMoneyRobbed(int idx, int[] nums) {
        if (idx < 0) return 0;

        if (idx == 0) return nums[0];

        int rob = nums[idx] + maximumMoneyRobbed(idx - 2, nums);
        int robNext = maximumMoneyRobbed(idx - 1, nums);

        return Math.max(rob, robNext);
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maximumMoneyRobbed(n - 1, nums, dp);
    }

    private static int maximumMoneyRobbed(int idx, int[] nums, int[] dp) {
        if (idx < 0) return 0;

        if (idx == 0) return nums[0];

        if (dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + maximumMoneyRobbed(idx - 2, nums, dp);
        int robNext = maximumMoneyRobbed(idx - 1, nums, dp);

        return dp[idx] = Math.max(rob, robNext);
    }

    public int rob4(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int idx = 1; idx < n; idx++) {
            int rob = nums[idx];
            if(idx > 1) rob += dp[idx-2];

            int robNext = dp[idx - 1];

            dp[idx] = Math.max(rob, robNext);
        }

        return dp[n - 1];
    }
}
