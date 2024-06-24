package Leetcode;

public class Left_and_Right_Sum_Differences {
    public static void main(String[] args) {
        System.out.println(leftRightDifference(new int[]{10,4,8,3}));
    }

    static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n], res = new int[n];

        for (int i = 1; i < n; i++){
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--){
            right[i] = right[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++){
            res[i] = Math.abs(left[i] - right[i]);
        }

        return res;
    }
}
