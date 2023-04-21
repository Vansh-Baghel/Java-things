package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/two-sum/
public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {
//    Brute force
//        int[] ans = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+ 1 ; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    ans[0] = i;
//                    ans[1] = j;
//                }
//            }
//        }
//        return ans;

        int[] ans = new int[2];
        HashMap<Integer , Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])){
                ans[0] = hm.get(target - nums[i]);
                ans[1] = i;
            }
            hm.put(nums[i], i);
        }
        return ans;
    }
}
