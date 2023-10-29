package Leetcode;

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        // We are not considering the first and last num of prefix and suffix so that we could get the results which doesn't include the current number.
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            prefix[i] *= suffix[i];
        }
        return prefix;
    }
}
