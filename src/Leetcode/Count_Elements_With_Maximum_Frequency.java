package Leetcode;

import java.util.Arrays;

public class Count_Elements_With_Maximum_Frequency {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);
        int maxFreq = 1, occurences = 1, n = nums.length;

        for (int i = 0; i < n - 1; i++){
            int freq = 1;

            while (i + 1 < n && nums[i] == nums[i + 1]) {
                freq++;
                i++;
            }

            if (maxFreq < freq) {
                maxFreq = freq;
                occurences = 1;
            } else if (maxFreq == freq) occurences++;
        }

        return maxFreq * occurences;
    }
}
