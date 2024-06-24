package Leetcode;

import java.util.*;

public class Count_Good_Meals {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        System.out.println(countPairs(nums));
    }

    static int mod = 1000000007;

    static int countPairs(int[] deliciousness) {
        int res = 0;
        // HashSet nhi because we are having multiple same numbers which are treated individually.
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int cur : deliciousness) {
            // When i = 0, its anyways empty.
            for (int j = 0; j < 21; j++) {
                int pow = (int) Math.pow(2, j);
                if (hm.containsKey(pow - cur)) {
                    res = (res + hm.get(pow - cur)) % mod;
                }
            }

            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }

        return res;
    }
}
