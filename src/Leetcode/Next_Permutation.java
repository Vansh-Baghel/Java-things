package Leetcode;
import java.util.*;

public class Next_Permutation {
    public static void main(String[] args) {
        int[] arr = {2,3,1};
        nextPermutation(arr);
    }
    static void nextPermutation(int[] nums) {
        int breakPoint = -1;

        // Here we are finding the breakPoint from back of the array where i is smaller than i + 1 ie 3rd index smaller than 4th from back.
        for (int i = nums.length - 2 ; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                breakPoint = i;
                break;
            }
        }

        // if breakPoint is -1 (assigned value), it means that the array is at its max permutation. In this case, we reverse it to get the first and smallest permutation.
        if (breakPoint == -1) {
            Arrays.sort(nums);
        }
        // Else we have to swap the last number (ie the smallest from breakPoint till end with the breakpoint)
        else {
            for (int i = nums.length - 1 ; i >= breakPoint ; i--){
                if (nums[i] > nums[breakPoint]){
                    int temp = nums[i];
                    nums[i] = nums[breakPoint];
                    nums[breakPoint] = temp;
                    break;
                }
            }

            // Lastly, we have to reverse the array from breakPoint till the end because it will be in descending order.
            int s = breakPoint + 1;
            int e = nums.length - 1;

            while (s < e){

                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
    }
}
