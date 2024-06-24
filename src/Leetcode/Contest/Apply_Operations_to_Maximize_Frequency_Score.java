package Leetcode.Contest;

import java.util.*;

public class Apply_Operations_to_Maximize_Frequency_Score {
    public static void main(String[] args) {
        int[] nums = {1,4,4,2,4};
        System.out.println(maxFrequencyScore(nums, 0));
    }

    static int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int s = 0;
        int e = 1;
        int freq = 1;
        while (e < n){
            e++;
            int mid = (s + e) /2;
            long target = nums[mid];

            // Finding the total number required to convert the left side into the target, and subtracting with sum of left.
            long leftSum = (target * (mid - s)) - (prefixSum[mid] - prefixSum[s]);
            long rightSum = (prefixSum[e] - prefixSum[mid] - (target * (e - mid)));
            long cost = leftSum + rightSum;

            // If valid nhi hua, matlab cost zyada lagg rha hai from the k, toh window small krte jaao
            while (s < e && cost > k) {
                s++;
                mid = (s + e) /2;
                target = nums[mid];
                leftSum = target * (mid - s) - prefixSum[mid] - prefixSum[s];
                rightSum = (prefixSum[e] - prefixSum[mid] - target * (e - mid));
                cost = leftSum + rightSum;
            }
            freq = Math.max(e - s, freq);
        }

        return freq;
    }
}
