package Leetcode;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] numbers = {-1,-100,3,99};

        rotate1(numbers, 2);
    }

    static void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    static void rotate2(int[] nums, int k) {
        int n = nums.length;

        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    private static void reverse(int idx1, int idx2, int[] nums) {
        while (idx1 < idx2){
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++;
            idx2--;
        }
    }
}
