//https://leetcode.com/problems/remove-element/
package Leetcode;

import java.util.Arrays;

public class Remove_Element {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums , 3));
        System.out.println(Arrays.toString(nums));
    }

    static int removeElement(int[] nums, int val) {
        int newArrIndex = 0;

        for (int i = 0; i < nums.length; i++) {
//            If its not equal to val , then just print that element . newArrIndex won't change if the the val matches , therefore it will properly print the values inside the original array without skipping the elements. And let the further elements be the same after printing the non val elements .
            if (nums[i] != val){
                nums[newArrIndex] = nums[i];
                newArrIndex += 1;
            }
        }
        return newArrIndex;
    }
}
