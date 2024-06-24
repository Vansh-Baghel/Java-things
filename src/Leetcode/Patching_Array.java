package Leetcode;

public class Patching_Array {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int res = 0, idx = 0;

        for (long i = 1; i <= n; i++){
            // If the current number is smaller or equal to i, then add the cur coin num in the res list, and increase the sum.
            if (idx < nums.length && nums[idx] <= i){
                sum += nums[idx];
                idx++;
            } else {
                // If the sum is < i, then it means that the sum will take care of the i.
                if (sum >= i) {
                    // Can modify this because we know that all the numbers which are smaller than the sum will surely be formed.
                    i = sum;
                    continue;
                }
                sum+=i;
                res++;
            }
        }

        return res;
    }
}
