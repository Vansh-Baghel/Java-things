package Leetcode.Contest;

import java.util.Arrays;

public class Divide_Array_Into_Arrays_With_Max_Difference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0, n = nums.length, maxLen = 3, idx = 0, ansIdx = 0;
        int[][] res = new int[n/3][maxLen];
        int[] arr = new int[maxLen];

        for (int e = 0; e < n; e++) {
            if (nums[e] - nums[s] <= k){
                arr[idx++] = nums[e];
            } else {
                return new int[][]{};
            }
            if (idx == maxLen){
                s = e + 1;
                idx = 0;
                res[ansIdx++] = arr;
                arr = new int[maxLen];
            }
        }

        return res;
    }
}
