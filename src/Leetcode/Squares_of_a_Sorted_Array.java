package Leetcode;
import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
        public static void main(String args[]){
            int[] arr = {-4,-1,0,3,10};
            int[] res = sortedSquares(arr);
            System.out.println(Arrays.toString(res));
        }

        static int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
//                It anyways will become +ve after square
                    nums[i] *= nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
}
