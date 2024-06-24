package Leetcode;

import java.util.*;

public class N_Repeated_Element_in_Size_N_Array {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for (int num: nums){
            if (hs.contains(num)) return num;

            hs.add(num);
        }

        return -1;
    }

    public int repeatedNTimes2(int[] nums) {
        int n = nums.length;
        int[] freq = new int[10001];

        for (int num: nums){
            if (freq[num] != 0) return num;

            freq[num]++;
        }

        return -1;
    }

}
