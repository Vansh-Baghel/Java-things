//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
package Leetcode;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    static int removeDuplicates(int[] nums) {
        int nonDup = 0;

        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] != nums[i-1]){
//                 We are changing the original array nums. The first element will be unchanged and we will change the elements from second element. Therefore ++nonDup.
                nums[++nonDup] = nums[i];

            }
        }
//  We increment the nonDup because as the first element is unchanged . it will also not count that element.
        return ++nonDup;
    }
}
