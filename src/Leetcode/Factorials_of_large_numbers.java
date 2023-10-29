package Leetcode;

import java.util.*;

public class Factorials_of_large_numbers {
    public static void main(String[] args) {
        System.out.println(factorial(897));
    }

    static ArrayList<Integer> factorial(int N) {
        int[] nums = new int[10000];
        int size = 1;
        ArrayList<Integer> res = new ArrayList<>();
        nums[0] = 1;

        for (int multiplier = 2; multiplier <= N; multiplier++) {
            size = multiply(multiplier, size, nums);
        }

        for (int i = size-1; i >= 0; i--) {
            res.add(nums[i]);
        }

        return res;
    }

    static int multiply(int multiplier, int size, int[] nums) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int product = multiplier * nums[i];
            product += carry;
            nums[i] = product % 10;
            carry = product / 10;
        }

        while (carry > 0) {
            nums[size] = carry%10;
            size++;
            carry = carry/10;
        }
        return size;
    }
}
