package Leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }

    static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int n = nums.length, res = 0, i = 0, j = 0;

        while (j < n){
            minHeap.add(new int[]{nums[j], j});
            maxHeap.add(new int[]{nums[j], j});

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                int minIdx = minHeap.peek()[1];
                int maxIdx = maxHeap.peek()[1];

                i = Math.min(minIdx, maxIdx) + 1;

                while (minIdx < i) {
                    minHeap.poll();
                    minIdx = minHeap.peek()[1];
                }
                while (maxIdx < i) {
                    maxHeap.poll();
                    maxIdx = maxHeap.peek()[1];
                }
            }

            int size = j - i + 1;
            res = Math.max(res, size);
            j++;
        }
        return res;
    }
}
