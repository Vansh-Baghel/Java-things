package Leetcode;

import java.util.Arrays;

public class Maximum_Product_of_Two_Elements_in_an_Array {
    static int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int lastNum = nums[n - 1];
        int secLastNum = nums[n - 2];

        return (lastNum - 1) * (secLastNum - 1);
    }
}
