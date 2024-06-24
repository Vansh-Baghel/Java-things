package Leetcode.Contest;

import java.util.*;

public class Count_Elements_With_Maximum_Frequency {
    public static void main(String[] args) {
        int[] nums = {10,11,11,12,6,9,19};
        System.out.println(maxFrequencyElements(nums));
    }
    static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        int maxi = 1, cnt = 0, res = 0, s = 0, i = 0, n = nums.length;

        while (i < n){
            if (nums[i] != nums[s]){
                maxi = Math.max(maxi, i - s);
                s = i;
            }

            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            i++;
        }

        maxi = Math.max(maxi, i - s);

        for (var e: hm.entrySet()){
            if (e.getValue() == maxi) res+=maxi;
        }

        return res;
    }
}
