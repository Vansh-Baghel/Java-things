package Leetcode.Contest;

public class Count_the_Number_of_Incremovable_Subarrays_I {
    static int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreasing(nums, i, j)) res++;
            }
        }

        return res;
    }

    private static boolean isIncreasing(int[] nums, int start, int end) {

        for(int i=0; i<start-1;i++){
            if(nums[i] >= nums[i + 1]){
                return false;
            }
        }

        // Checking the left side ka last with the right side ka first
        if (start > 0 && end < nums.length-1 && nums[start-1]>=nums[end + 1]) return false;

        for (int i = end + 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }

        return true;
    }
}
