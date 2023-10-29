package Leetcode.Contest;

import java.util.Arrays;

public class Find_Indices_With_Index_and_Value_Difference_I {
    public static void main(String[] args) {
        int[] nums = {5,1,4,1};
        System.out.println(Arrays.toString(findIndices(nums, 2, 4)));
    }

    static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        int n = nums.length;

        for (int i = 0; i < n - indexDifference; i++) {
            for (int j = i+indexDifference; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}
