package Leetcode;

import java.util.Arrays;

public class Minimum_Number_of_Operations_to_Make_Array_Empty {
    public static void main(String[] args) {
        int[] arr = {2,3,3,2,2,4,2,3,4};
        System.out.println(minOperations(arr));
    }
    static int minOperations(int[] nums) {
            int s = 0, e = 0, n = nums.length, res = 0;
            Arrays.sort(nums);
            while (e < n){
                int dif = 0;
                while (e < n && nums[e] == nums[s]){
                    e++;
                }

                dif = e - s;

                if (dif == 1) return -1;
                res += count(dif, nums);

                s = e;
            }

            return res;
        }

        private static int count(int dif, int[] nums) {
            int res = 0;

            while (dif % 3 != 0) {
                dif -= 2;
                res++;
            }

            return res + dif / 3;
    }
}
