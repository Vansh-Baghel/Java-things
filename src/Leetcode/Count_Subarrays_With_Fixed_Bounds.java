package Leetcode;

import java.util.PriorityQueue;

public class Count_Subarrays_With_Fixed_Bounds {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int minK = 1;
        int maxK = 1;

        System.out.println(countSubarrays(nums, minK, maxK));
    }

    static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, culp = -1, minIdx = -1, maxIdx = -1, minPos = 0;
        long ans = 0;

        // 1,1,1,1
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur > maxK || cur < minK){
                culp = i;
            }

            if (cur == minK) minIdx = i;
            if (cur == maxK) maxIdx = i;

            minPos = Math.min(minIdx, maxIdx);
            ans += Math.max(0, minPos - culp);
        }

        return ans;
    }
}
