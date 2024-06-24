package Leetcode;

import java.util.*;

public class Arithmetic_Slices_II_Subsequence {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{7,7,7,7,7}));
    }

    static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long res = 0;
        HashMap<Long, Integer>[] hm = new HashMap[n];

        for(int i = 0; i < n; i++){
            hm[i] = new HashMap<>();
            for (int j = 0; j < i; j++){
                long dif = (long)nums[i] - nums[j];
                int count_at_j = 0;
                if (hm[j].containsKey(dif)) count_at_j = hm[j].get(dif);

                hm[i].put(dif, hm[i].getOrDefault(dif, 0) + count_at_j + 1);
                res += count_at_j;
//                System.out.print(count_at_j + " ");
            }
//            System.out.println();
        }

        return (int)res;
    }
}
