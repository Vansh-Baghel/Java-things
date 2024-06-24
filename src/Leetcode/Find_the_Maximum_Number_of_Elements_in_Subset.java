package Leetcode;

import java.util.*;

public class Find_the_Maximum_Number_of_Elements_in_Subset {
    public int maximumLength(int[] nums) {
        int n = nums.length, res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num: nums){
            hm.put(num, hm.getOrDefault(num , 0) + 1);
        }

        // Because if 4 comes before 2, then it will not counted.
        Arrays.sort(nums);

        for (int cur: nums){
            int cnt = 0;

            while(hm.containsKey(cur)){
                int v = hm.get(cur);

                // Adding v because 1 ka any power is 1
                if (cur == 1) cnt += v;
                else if (v >= 2) cnt += 2;
                else {
                    cnt += 1;

                    // Break because if one time aya, matlab vo peak hee hai.
                    break;
                }

                hm.remove(cur);
                cur = cur * cur;
            }

            // Because if even count hai, means we dont have the peak wala num, all the occurances were 2.
            if (cnt % 2 == 0){
                cnt--;
            }

            res = Math.max(res, cnt);
        }

        return res;
    }
}
