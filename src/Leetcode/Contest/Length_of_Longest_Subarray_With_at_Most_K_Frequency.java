package Leetcode.Contest;

import java.util.HashMap;

public class Length_of_Longest_Subarray_With_at_Most_K_Frequency {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLength(nums, 2));
    }

    static int maxSubarrayLength(int[] nums, int k) {
        int s = 0, e = 0, res = 0, n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        while (e < n){
            hm.put(nums[e], hm.getOrDefault(nums[e], 0) + 1);

            if (hm.get(nums[e]) <= k){
                res = Math.max((e - s) + 1, res);
            }

            while (hm.get(nums[e]) > k){
                hm.put(nums[s], hm.get(nums[s]) - 1);
                s++;
            }

            e++;
        }

        return res;
    }
}
