package Leetcode;
import java.util.*;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Not checking if k is 0 as difference would atleast be 1.
        if (k == 0) return false;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
//            Checking the key if its same or not using containsKey, and getting the value stored in that key using get method.
            if (hm.containsKey(nums[i]) && i - hm.get(nums[i]) <= k) return true;
            hm.put(nums[i] , i);
        }
        return false;
    }
}
