package Leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array {
    static int findMin(int[] nums) {
        int s = 0, n = nums.length, e = n - 1, pos = 0;

        while (s < e){
            int m = s + (e - s) / 2;

            if (nums[s] <= nums[m]) {
                pos = Math.min(pos, nums[s]);
                s = m + 1;
            }
            else {
                pos = Math.min(pos, nums[e]);
                e = m - 1;
            };
        }

        return pos;
    }
}
