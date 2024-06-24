package Leetcode.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Count_the_Number_of_Good_Partitions {
    public static void main(String[] args) {
        int[] n = {1,1,1,1};
        System.out.println(numberOfGoodPartitions(n));
    }

    static int numberOfGoodPartitions(int[] nums) {
        int n = nums.length, e = 0, totalGroups = 0;
        int mod = (int)(1e9 + 7), res = 1;

        HashMap<Integer, Integer> hm = new HashMap();

        for (int i = 0; i < n; i++) {
            // Storing the last index of the particular occurance
            hm.put(nums[i] , i);
        }

        // This will give us total pair of nums whose first and last index of current number which is present. If current num ka occurance is smaller than koi prev num ka last index, tab toh form hee nhi ho skte, toh aage badho, because prevNum k last index k baad se ek new pair consider krenge.
        for (int i = 0, j = 0; i < n; i++) {
            if (i > j) {
                totalGroups++;
            }
            j = Math.max(j, hm.get(nums[i]));
        }

        // Each num will either go with prev nums or will go with further, to 2 ways mai hoga, therefore, (2 ^ totalGroups) % m.

        for (int i = 0; i < totalGroups; i++) {
            res = res * 2 % mod;
        }

        return res;
    }
}
