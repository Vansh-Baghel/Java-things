package Leetcode.Contest;

import java.util.*;

public class Find_Indices_With_Index_and_Value_Difference_II {
    public static void main(String[] args) {
        int[] nums = {3,12,40};
        System.out.println(Arrays.toString(findIndices(nums, 0, 9)));
    }

    static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        if (indexDifference == 0 && valueDifference == indexDifference) return ans;

        Arrays.fill(ans, -1);

        for (int i = indexDifference; i < n; i++) {
            maxHeap.add(nums[i]);
            hm.put(nums[i], i);
        }

        if (!maxHeap.isEmpty()) {
            for (int i = 0; i < n - indexDifference; i++) {
                System.out.println(nums[i] - maxHeap.peek());

                if (Math.abs(i - hm.get(maxHeap.peek())) >= indexDifference && Math.abs(nums[i] - maxHeap.peek()) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = hm.get(maxHeap.peek());
                }
                maxHeap.remove(nums[i + indexDifference]);
            }

        }
            return ans;
    }
}

