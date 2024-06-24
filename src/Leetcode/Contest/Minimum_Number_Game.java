package Leetcode.Contest;

import java.util.Arrays;

public class Minimum_Number_Game {
    public int[] numberGame(int[] nums) {
        int idx = 0, n = nums.length;
        int[] res = new int[n];
        Arrays.sort(nums);

        for (int i = 1; i < n; i+=2) {
            res[idx++] = nums[i];
            res[idx++] = nums[i-1];
        }

        return res;
    }
}
