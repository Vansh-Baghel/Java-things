package Leetcode;

import java.util.*;

public class House_Robber_II {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(rob3(arr));
    }
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

    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1) return valueInHouse[0];
        ArrayList<Integer> t1 = new ArrayList<>(), t2 = new ArrayList<>();
        for (int i = 0; i < valueInHouse.length; i++) {
            if (i != 0) t1.add(valueInHouse[i]);
            if (i != valueInHouse.length - 1) t2.add(valueInHouse[i]);
        }

        return Math.max(maximumNonAdjacentSum4(t1), maximumNonAdjacentSum4(t2));
    }






















    static int rob(int[] nums) {
        int n = nums.length;
        return Math.max(maxMoney(1, n - 1, nums), maxMoney(0, n - 2, nums));
    }

    static int maxMoney(int idx, int n, int[] nums){
        if (idx > n) return 0;

        int pick = nums[idx] + maxMoney(idx+2, n, nums);
        int notPick = maxMoney(idx+1, n, nums);

        return Math.max(pick, notPick);
    }

    static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.max(maxMoney(1, n - 1, nums, dp), maxMoney(0, n - 2, nums, dp));
    }

    static int maxMoney(int idx, int n, int[] nums, int[] dp){
        if (idx > n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + maxMoney(idx+2, n, nums, dp);
        int notPick = maxMoney(idx+1, n, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    static int rob3(int[] nums) {
        int n = nums.length, idx1 = 0, idx2=0;

        if (n == 1) return nums[0];

        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if(i!=0) nums1[idx1++]=nums[i];
            if(i!=n-1) nums2[idx2++]=nums[i];
        }

        return Math.max(maxMoney(nums1), maxMoney(nums2));
    }

    private static int maxMoney(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int idx = 1; idx < n; idx++) {
            int pick = nums[idx];
            if (idx - 2 >= 0) pick += dp[idx-2];
            int notPick = dp[idx-1];
            dp[idx] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}
