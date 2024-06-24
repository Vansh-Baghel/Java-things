package Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Maximum_Sum_of_Almost_Unique_Subarray {
    public static void main(String[] args) {
        int[] input = {1,2,2};

        // Convert the array to a List<Integer>
        List<Integer> nums = Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(maxSum(nums, 2,2));
    }

    static long maxSum(List<Integer> nums, int m, int k) {
        int s = 0;
        long sum = 0, res = 0;
        int n = nums.size();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int e = 0; e < n; e++){
            sum += nums.get(e);
            hm.put(nums.get(e), hm.getOrDefault(nums.get(e), 0) + 1);

            if (e - s + 1 == k){
                if (hm.size() >= m){
                    res = Math.max(res, sum);
                }

                sum -= nums.get(s);
                hm.put(nums.get(s), hm.getOrDefault(nums.get(s), 0) - 1);
                if (hm.get(nums.get(s)) == 0) hm.remove(nums.get(s));
                s++;
            }
        }

        return res;
    }
}
