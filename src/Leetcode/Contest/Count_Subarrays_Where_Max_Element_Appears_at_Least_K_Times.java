package Leetcode.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    public static void main(String[] args) {
        int[] n = {1,3,2,3,3};
        System.out.println(countSubarrays(n, 2));
    }

    static long countSubarrays(int[] nums, int k) {
        int s = 0, n = nums.length, e = 0, maxi = 0;
        long res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num: nums) {
            maxi = Math.max(maxi, num);
        }

        while (e < n){
            hm.put(nums[e], hm.getOrDefault(nums[e], 0) + 1);

            while (hm.containsKey(maxi) && hm.get(maxi) >= k){
                hm.put(nums[s], hm.get(nums[s]) - 1);
                s++;

                // Because all aage k will also be one of the subarrays
                res += n - e;
            }

            e++;
        }

        return res;
    }
}
