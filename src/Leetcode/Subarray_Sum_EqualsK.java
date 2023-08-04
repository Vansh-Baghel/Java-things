package Leetcode;
import java.util.*;

public class Subarray_Sum_EqualsK {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        System.out.println(subarraySum(nums,0));
    }

    static int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for(int i = 0; i < nums.length; i++){
//            int sum = 0;
//
//            for (int j= i; j<nums.length;j++){
//                sum+= nums[j];
//                if (sum == k){
//                    count++;
//                }
//            }
//        }
//        return count;


        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int prefixSum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            if (hm.containsKey(prefixSum - k)){
                count+=hm.get(prefixSum - k);
            }
            hm.put(prefixSum, hm.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
