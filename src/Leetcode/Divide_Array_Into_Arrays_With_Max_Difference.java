package Leetcode;

import java.util.*;

public class Divide_Array_Into_Arrays_With_Max_Difference {
    public static void main(String[] args) {
        int[] nums = {15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2};
        System.out.println(Arrays.toString(divideArray(nums, 2)));
    }

    static int[][] divideArray(int[] nums, int k) {
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

    static int[][] divideArray2(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int[][] res = new int[n/3][3];
        int i = 0;

        for (int e = 2; e < n; e+=3){
            if (nums[e] - nums[e - 2] <= k){
                res[i++] = new int[]{nums[e-2], nums[e-1], nums[e]};
            } else return new int[][]{};
        }

        return res;
    }
}
