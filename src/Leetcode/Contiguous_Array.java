package Leetcode;

import java.util.HashMap;

public class Contiguous_Array {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength3(nums));
    }

    // Brute force, 10 pow 5 is the limit, and if both the loops run, it will give 10 raise to 10, but 10 raise to 9 gives TLE.
    static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) sum --;
                else sum++;

                if (sum == 0) maxi = Math.max(maxi, j - i + 1);
            }
            sum = 0;
        }

        return maxi;
    }

    static int findMaxLength2(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int sum = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] == 0) sum -= 1;
            else sum += 1;

            // Handling cases for sum == 0, and it will be from index 0 only. Therefore we return idx+1.
            if (sum == 0) maxi = Math.max(maxi, idx+1);

            // Else we return the previous occurance ke idx k saath.
            if (hm.containsKey(sum)){
                maxi=Math.max(maxi, (idx + 1) - hm.get(sum));
            } else {
                hm.put(sum, idx+1);
            }
        }
        return maxi;
    }

    static int findMaxLength3(int[] nums) {
        int zeros = 0, ones = 0, res = 0, n = nums.length;
        boolean flag = false;

        for (int num: nums){
            if ((ones != 0 || zeros != 0) && zeros == ones) {
                flag = true;
                res = zeros;
            }

            if (num == 0) zeros++;
            else ones++;
        }

        if (res == 0 && !flag) return 0;
        else if (res == 0 && flag) return 2;
        return res * 2;
    }
}
