package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_IV {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4_2(nums, target));
    }

    static int ans = 0;

    static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        getAllCombinations(0, n,0, nums, target, list);
        return ans;
    }

    private static void getAllCombinations(int idx, int n, int sum, int[] nums, int target, List<Integer> list) {
        if (sum == target) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (sum > target) break;

            list.add(i);
            getAllCombinations(i + 1, n, sum + nums[i], nums, target, list);
            list.remove(list.size() - 1);
        }
    }

    static int combinationSum4_2(int[] nums, int target) {
        int n = nums.length;

        return getAllCombinations(0, n,0, nums, target);
    }

    private static int getAllCombinations(int idx, int n, int sum, int[] nums, int target) {
        if (sum == target) return 1;
        if (sum > target) return 0;

        int res = 0;
        for (int i = idx; i < n; i++) {
            int take = getAllCombinations(0, n, sum + nums[i], nums, target);
            res+=take;
        }

        return res;
    }

    static int combinationSum4_3(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[201][1001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getAllCombinations(0, n,0, nums, target, dp);
    }

    private static int getAllCombinations(int idx, int n, int sum, int[] nums, int target, int[][] dp) {
        if (sum == target) return 1;
        if (sum > target) return 0;
        if (dp[idx][sum] != -1) return dp[idx][sum];

        int res = 0;
        for (int i = idx; i < n; i++) {
            int take = getAllCombinations(0, n, sum + nums[i], nums, target, dp);
            res+=take;
        }

        return dp[idx][sum] = res;
    }

    static int combinationSum4_4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[201][1001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getAllCombinations2(0, n,0, nums, target, dp);
    }

    private static int getAllCombinations2(int idx, int n, int sum, int[] nums, int target, int[][] dp) {
        if (sum == target) return 1;
        if (sum > target || idx > n) return 0;
        if (dp[idx][sum] != -1) return dp[idx][sum];

        int pick = getAllCombinations2(0, n, sum + nums[idx], nums, target, dp);
        int notPick = getAllCombinations2(idx + 1, n, sum, nums, target, dp);

        return dp[idx][sum] = pick + notPick;
    }


















    static int ccombinationSum4(int[] nums, int target) {
        int n = nums.length;
        return maxCombinations(n, target, nums);
    }

    private static int maxCombinations(int n, int target, int[] nums) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        int pick = 0;

        for (int i = 0; i < n; i++) {
            pick += maxCombinations(n, target - nums[i], nums);
        }

        return pick;
    }

    static int ccombinationSum4_1(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[201][1001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getAllCombinations_2(0, n,0, nums, target, dp);
    }

    private static int getAllCombinations_2(int idx, int n, int sum, int[] nums, int target, int[][] dp) {
        if (sum == target) return 1;
        if (sum > target || idx > n) return 0;
        if (dp[idx][sum] != -1) return dp[idx][sum];

        int pick = getAllCombinations_2(0, n, sum + nums[idx], nums, target, dp);
        int notPick = getAllCombinations_2(idx + 1, n, sum, nums, target, dp);

        return dp[idx][sum] = pick + notPick;
    }

    static int ccombinationSum4_3(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(i - j >= 0) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }
}
