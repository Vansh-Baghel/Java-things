package Leetcode.Contest;

import java.util.*;

public class Maximum_Size_of_a_Set_After_Removals {
    public static void main(String[] args) {
        System.out.println(maximumSetSize(new int[]{1,1,1,1}, new int[]{9,2,3,4}));
    }

    static int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums2.length, del = n / 2;

        for (int num: nums1){
            if (del != 0 && hm.containsKey(num)) del--;
            else hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int del2 = n / 2;

        for (int num: nums2){
            if (del2 != 0 && hm.containsKey(num) || hs.contains(num)) {
                del2--;
                hs.remove(num);
            } else if (del != 0 && hm.containsKey(num)){
                if (hm.get(num) == 1) {
                    hm.remove(num);
                    del--;
                } else {
                    if (del < hm.get(num)) hm.put(num, hm.get(num) - del);
                    else {
                        del -= hm.get(num);
                        hm.remove(num);
                    }
                }
            }

            hs.add(num);
        }

        for (var e: hm.entrySet()){
            hs.add(e.getKey());
        }

        return hs.size() - del - del2;
    }
}
