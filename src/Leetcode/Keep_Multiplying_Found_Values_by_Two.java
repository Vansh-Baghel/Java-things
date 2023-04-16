package Leetcode;

import java.util.Arrays;

public class Keep_Multiplying_Found_Values_by_Two {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        for(int num : nums){
            if (num == original){
                original = num * 2;
            }
        }
        return original;
    }
}
