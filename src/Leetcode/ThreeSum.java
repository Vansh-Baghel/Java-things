//https://leetcode.com/problems/3sum/
package Leetcode;

import java.util.*;

public class ThreeSum {
//    This is new arrayList we defined in the global scope.
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
//            Here we are checking for duplicates of a.
            if (i == 0 || nums[i - 1] != nums[i]){
//            i and j are the two pointer which will start from start and end .
//            -nums[i] is basically -a because b + c = 0 - a.
                result = twoPointer(i + 1 , nums.length - 1 , nums , -nums[i]);
            }
        }
        return result;
    }

//    twoPointer has 1 pointer starting from start and another from last , and we compare it with the target and if the target is greater than their sum , then we increase the value by incrementing from i side . Decreasing from j side means the target sum is small.
    public List<List<Integer>> twoPointer(int i, int j, int[] nums, int target) {
        int a1 = nums[i - 1];

        while (i < j){
            if (nums[i] + nums[j] < target){
                i++;
            }
            else if (nums[i] + nums[j] > target){
                j--;
            }
    //        This else condition means its equal to target.
            else {
    //            Because we cannot add int type in the result directly as there we need list type.
                List<Integer> list = new ArrayList<>();
                list.add(a1);
                list.add(nums[i]);
                list.add(nums[j]);

                result.add(list);

//                remove the duplicate in b
                while (i < j && nums[i] == nums[i + 1]){
                    i++;
                }
//                remove the duplicate in c
                while (i < j && nums[j] == nums[j - 1]){
                    j--;
                }
//                Changing value after adding the values in the list.
                i++;
                j--;
            }
        }
        return result;
    }
}
