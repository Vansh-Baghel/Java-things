package Leetcode;

import java.util.*;

public class Find_the_Difference_of_Two_Arrays {
    public static void main(String[] args) {
        int[] n1 = {-80,-15,-81,-28,-61,63,14,-45,-35,-10};
        int[] n2 = {-1,-40,-44,41,10,-43,69,10,2};
        System.out.println(findDifference(n1, n2));
    }

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int num : nums1) {
            hm.put(num, false);
        }

        for (int num : nums2) {
            if (!hm.containsKey(num)) {
                if (!ans.get(1).contains(num)) ans.get(1).add(num);
            } else {
                hm.put(num, true);
            }
        }

        for (Map.Entry<Integer, Boolean> entry : hm.entrySet()) {
            if (!entry.getValue()) {
                ans.get(0).add(entry.getKey());
            }
        }

        return ans;
    }
}
