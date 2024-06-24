package Leetcode;

import java.util.Arrays;

public class Check_if_Array_Is_Sorted_and_Rotated {
    public static void main(String[] args) {
        int[] nums = {6,10,6};
        System.out.println(check(nums));
    }

    static boolean check(int[] nums) {
        int cnt = 0,  n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) cnt++;
        }

        if (nums[n - 1] > nums[0]) cnt++;

        return cnt <= 1;
    }
}
