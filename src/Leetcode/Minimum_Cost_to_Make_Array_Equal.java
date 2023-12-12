package Leetcode;

public class Minimum_Cost_to_Make_Array_Equal {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        System.out.println(minCost(nums, cost));
    }

    static long minCost(int[] nums, int[] cost) {
        long ans = Integer.MAX_VALUE;
        int n = nums.length, s = 10000000, e = 0;

        for (int num: nums) {
            s = Math.min(s, num);
            e = Math.max(e, num);
        }

        while (s <= e){
            int m = s + (e - s) / 2;
            long midSum = totalCostTillMid(m, n, nums, cost);
            long midNextSum = totalCostTillMid(m+1, n, nums, cost);
            ans = Math.min(midSum, midNextSum);

            if (midSum < midNextSum){
                e = m - 1;
            } else s = m + 1;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static long totalCostTillMid(int m, int n, int[] nums, int[] cost) {
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum+=(long) Math.abs(nums[i] - m) * cost[i];
        }

        return totalSum;
    }
}
