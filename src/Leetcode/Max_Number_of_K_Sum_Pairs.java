package Leetcode;

import java.util.Arrays;

public class Max_Number_of_K_Sum_Pairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 5;
        System.out.println(maxOperations(arr, k));
    }

    static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0, e = nums.length - 1, ans = 0;

        while (s < e){
            if (nums[s] + nums[e] > k){
                e--;
            } else if (nums[s] + nums[e] < k){
                s++;
            } else {
                s++;
                e--;
                ans++;
            }
        }

        return ans;
    }
}
