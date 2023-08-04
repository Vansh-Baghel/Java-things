package Leetcode;
import java.util.*;

public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};

        long ans = maximumSubarraySum(nums, 3);
        System.out.println(ans);
    }

    static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> hs = new HashSet();
        int maxSum = 0;
        int curSum = 0;
        int windowKaStart = 0;

        for (int end= 0 ; end < nums.length ; end++){
            curSum += nums[end];

            // hs.add returns boolean value. If duplicate elements appear, then hs.add will return false. else it will add the element in the hs.
            while (!hs.add(nums[end])){
                int start = nums[windowKaStart];

                curSum -= start;
                hs.remove(start);
                windowKaStart++;
            }

            // Agar subArray ka length k ke equal hua, toh check for maxSum, remove start element from curSum, remove the start value from the set to update it, and lastly update the start.
            if ((end - windowKaStart) == (k - 1)){
                    maxSum = Math.max(maxSum, curSum);

                int start = nums[windowKaStart];
                curSum -= start;
                hs.remove(start);
                windowKaStart++;
            }
        }

        return maxSum;
    }
}
