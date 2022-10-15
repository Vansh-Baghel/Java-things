//https://leetcode.com/problems/sort-colors/
package Leetcode;

import java.util.Arrays;

public class Sort_Colors {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
    }

//    https://www.youtube.com/watch?v=oaVa-9wmpns&t=432s
    static void sortColors(int[] nums) {
        int mid = 0;
        int low = 0;
        int high = nums.length - 1;
        while (mid <= high){
            if (nums[mid] == 0){
                swap(nums , low , mid);
                mid++;
                low++;
            }
            else if (nums[mid] == 1){
                mid++;
            }
            else if (nums[mid] == 2){
                swap(nums , mid , high);
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int mid, int num) {
        int temp = nums[mid];
        nums[mid] = nums[num];
        nums[num] = temp;
    }
}
