//https://leetcode.com/problems/move-zeroes/
package Leetcode;

public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int temp = 0;

// Using 2 pointers
// left will only move when we swap left and right. if right is not 0 then we will swap even if left is non zero because it will increment both left and right number. left counter will stop at 0 num once we increment both by swap.
        while (right != nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }

}
