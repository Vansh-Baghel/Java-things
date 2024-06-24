package Leetcode;

public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] nums = {6,-3,-10,0,2};
        System.out.println(maxProduct(nums, nums.length));
    }

    static int maxProduct(int[] nums) {
        int pre = 1, suf = 1, n = nums.length, maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;

            pre *= nums[i];
            suf *= nums[(n - 1) - i];

            maxi = Math.max(maxi, Math.max(pre, suf));
        }
        return maxi;
    }






    static long maxProduct(int[] arr, int n) {
        long[] prefix = new long[n+1], suffix = new long[n+1];
        long maxi=Integer.MIN_VALUE;

        prefix[0] = 1;
        suffix[n] = 1;

        for (int i = 0; i < n; i++){
            int num = arr[i];

            if (prefix[i] == 0) prefix[i+1] = num;
            else prefix[i+1] = prefix[i] * num;

            maxi = Math.max(maxi, prefix[i+1]);
        }

        for (int i = n-1; i >= 0; i--){
            int num = arr[i];

            if (suffix[i+1] == 0) suffix[i] = num;
            else suffix[i] = suffix[i+1] * num;

            maxi = Math.max(maxi, suffix[i]);
        }

        return maxi;
    }
}
