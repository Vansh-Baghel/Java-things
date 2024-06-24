package Leetcode;

public class Arithmetic_Slices {
    public static void main(String[] args) {
        int[] nums = {1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(nums));
    }
    static int numberOfArithmeticSlices(int[] nums) {
        int e = 2, n = nums.length, res = 0, cur = 0;

        while (e < n){
            if (nums[e] - nums[e-1] == nums[e-1] - nums[e-2]){
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
            e++;
        }

        return res;
    }
}
