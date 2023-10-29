package Leetcode.Contest;

public class Maximum_Value_of_an_Ordered_Triplet_I {
    public long maximumTripletValue(int[] nums) {
        long maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if ((long) (nums[i] - nums[j]) * nums[k] > maxi) maxi = (long)(nums[i] - nums[j]) * nums[k];
                }
            }
        }
        return maxi;
    }
}
