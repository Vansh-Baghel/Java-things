package Leetcode;
import java.util.*;

public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num: nums){
            // If the key already exists, then increase the count.
            if (hm.containsKey(num)){
                hm.put(num , hm.get(num) + 1);
                // Else just increment it.
            } else hm.put(num , 1);

            // If the num already exist in the list, we dont need to add it again.
            if (hm.get(num) > nums.length / 3 && !list.contains(num)){
                list.add(num);
            }
        }

        return list;
    }

}
