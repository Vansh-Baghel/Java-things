package Leetcode;

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,5,7,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
    static int[] searchRange(int[] nums, int target) {
        int s = 0, n = nums.length, e = n-1, m = 0, left = 0, right = 0;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        while (s <= e){
            m = s + (e - s) / 2;
            if (nums[m] < target) s = m + 1;
            else if (nums[m] > target) e = m - 1;
            else {
                int temp = m;
                while (temp >= 0 && nums[temp] == target) {
                    left = temp;
                    temp--;
                }
                ans[0] = left;
                temp = m;
                while (temp < n && nums[temp] == target) {
                    right = temp;
                    temp++;
                }
                ans[1] = right;
                break;
            }
        }

        return ans;
    }
}
