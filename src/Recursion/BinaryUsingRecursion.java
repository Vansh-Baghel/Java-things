package Recursion;

import java.util.*;

public class BinaryUsingRecursion {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int ans = search(nums , target , 0 , nums.length - 1);
        System.out.print(ans);
    }

    static int search(int[] nums, int target, int start , int end) {
        while (start < end){
            int mid = start + (end - start) / 2;

            if(target == nums[mid]){
                return mid;
            }
            else if (target < nums[mid]){
                return search(nums , target , start , mid - 1);
            }
            else if (target > nums[mid]){
                return search(nums , target , mid + 1 , end);
            }

        }
        return -1;
    }
}
