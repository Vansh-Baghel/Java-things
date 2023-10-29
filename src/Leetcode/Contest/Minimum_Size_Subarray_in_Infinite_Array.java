package Leetcode.Contest;

public class Minimum_Size_Subarray_in_Infinite_Array {
    public static void main(String[] args) {
        int[] n = {1,2,3};

        System.out.println(minSizeSubarray(n, 7));
    }
    static int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int totalSum= 0, prod = 1, sum=0, ans = 0;
        for(int num: nums) totalSum += num;

        prod += (int) Math.ceil(target/totalSum);

        return minSize(nums, n*prod-1, n, target);
    }

    private static int minSize(int[] nums, int idx, int n, int target) {
        if (target == 0) return 1;
        if (idx < 0) return 0;

        int pick = Integer.MAX_VALUE;
        if (target >= nums[idx%n]) pick = 1 + minSize(nums, idx-1, n,target-nums[idx%n]);
        int notPick = minSize(nums, idx-1,n, target);
        return Math.min(notPick, pick);
    }
}
