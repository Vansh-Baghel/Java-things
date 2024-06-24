package Leetcode;

import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign {
    public static void main(String[] args) {
        int[] nums = {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length, idx1 = 0, idx2 = 0;
        int[] pos = new int[n], neg = new int[n], res = new int[n];

        for (int i = 0; i < n; i++){
            if (nums[i] > 0) pos[idx1++] = nums[i];
            else neg[idx2++] = nums[i];
        }

        idx1 = 0;
        idx2 = 0;

        for (int i = 0; i < n; i++){
            if (i % 2 == 0) res[i] = pos[idx1++];
            else res[i] = neg[idx2++];
        }

        return res;
    }

    public int[] rearrangeArray2(int[] nums) {
        int m = nums.length, n = 1, p = 0;
        int[] res = new int[m];

        for (int num : nums) {
            if (num > 0) {
                res[p] = num;
                p += 2;
            } else {
                res[n] = num;
                n += 2;
            }
        }

        return res;
    }
}
