package Leetcode;

import java.util.*;

public class Convert_an_Array_Into_a_2D_Array_With_Conditions {
    static List<List<Integer>> findMatrix(int[] nums) {
        int[] alpha = new int[200];
        int maxi = 0, n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 0 based indexing par storing
            alpha[nums[i] - 1]++;
            maxi = Math.max(alpha[nums[i] - 1], maxi);
        }

        for (int i = 0; i < maxi; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j <= 200; j++) {
                if (alpha[j] > 0) {
                    // j + 1 because if j = 0 means waha we have stored the count of 1.
                    res.get(i).add(j + 1);
                    alpha[j]--;
                }
            }
        }

        return res;
    }

    static List<List<Integer>> findMatrix2(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        while (!hm.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Integer> toRemove = new ArrayList<>();
            for (var entry : hm.entrySet()) {
                int num = entry.getKey();
                int cnt = entry.getValue();

                cnt--;
                list.add(num);

                // Cannot remove here, else it will throw ConcurrentModificationException, because we are looping and modifying the hm at the same time.
                if (cnt == 0) toRemove.add(num);
                else hm.put(num, cnt);
            }
            res.add(list);
            for (int pair: toRemove){
                hm.remove(pair);
            }
        }

        return res;
    }
}
