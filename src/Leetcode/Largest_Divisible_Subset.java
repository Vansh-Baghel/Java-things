package Leetcode;

import java.util.*;

public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        int[] nums = {3,17};
        System.out.println(largestDivisibleSubset(nums));
    }

    static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, maxIdx = 0, maxi = 0;
        int[] dp = new int[n];
        int[] hash = new int[n];
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int idx = 0; idx < n; idx++){
            hash[idx]=idx;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++){
                if (nums[idx] % nums[prevIdx] == 0) {

                    // We are storing at each index that how much smaller nums have appeared before the current idx.
                    if (dp[idx] < dp[prevIdx] + 1){
                        dp[idx] = dp[prevIdx] + 1;
                        hash[idx] = prevIdx;
                    }
                }

                if (dp[idx] > maxi){
                    maxi = dp[idx];
                    maxIdx = idx;
                }
            }
        }

        res.add(nums[maxIdx]);

        while (hash[maxIdx] != maxIdx){
            maxIdx = hash[maxIdx];
            res.add(nums[maxIdx]);
        }

        Collections.reverse(res);

        return res;
    }
}
