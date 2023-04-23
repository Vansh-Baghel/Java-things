package Leetcode;
import java.util.*;

public class Most_Frequent_Even_Element {
    public int mostFrequentEven(int[] nums) {
        // 1 because there could be 0 4 times in an array, and if we use return ans == 1 ? -1 : ans, it could point the ans as -1 .
        int ans = 1;
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num: nums){
            // Only checking for even numbers.
            if (num % 2 == 0){
                // If the key already exists, then increase the count.
                if (hm.containsKey(num)){
                    hm.put(num , hm.get(num) + 1);
                    // Else just increment it.
                } else hm.put(num , 1);
            }

            // First check if the num contains any value or not because we are not storing the values of odd nums, then check if the value of num is greater than max or not.
            if (hm.get(num) != null && hm.get(num) >= max){

                // If they are same, means 2 nums with same number of counts. Therefore then return the min num.
                if (hm.get(num) == max){
                    ans = Math.min(ans, num);
                } else{
                    ans = num;
                    max = hm.get(num);
                }
            }
        }

        // If the max doesn't exist, we need to return -1. ans will always be 1 as we have assigned 1.
        return ans == 1 ? -1 : ans;
    }
}
