package Leetcode;

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,4};
        System.out.println(Arrays.toString(searchRange2(nums, 4)));
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









    static int[] searchRange2(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int[] ans = new int[2];

        Arrays.fill(ans, -1);

        if (nums.length == 0) return ans;

        int leftMost = findLeft(s, e, nums, target);
        int rightMost = findRight(s, e, nums, target);

        ans[0] = leftMost;
        ans[1] = rightMost;
        return ans;
    }

//    static int findTarget(int s, int e, int[] nums, int target) {
//        int ans = 0;
//
//        while (s <= e){
//            int m = s + (e - s)/2;
//            if (nums[m] > target) e = m - 1;
//            else if (nums[m] < target) s = m + 1;
//            else {
//                ans = m;
//                break;
//            }
//        }
//
//        return ans;
//    }

    static int findLeft(int s, int e, int[] nums, int target) {
        int leftMost = -1;

        while (s <= e){
            int m = s + (e - s)/2;
            if (nums[m] == target){
                leftMost = m;
                e = m - 1;
            } else if(nums[m] > target) {
                e = m - 1;
            } else s = m + 1;
        }

        return leftMost;
    }

    static int findRight(int s, int e, int[] nums, int target) {
        int rightMost = -1;

        while (s <= e){
            int m = s + (e - s)/2;
            if (nums[m] == target){
                rightMost = m;
                s = m + 1;
            } else if (nums[m] > target) {
                e = m - 1;
            } else s = m + 1;
        }

        return rightMost;
    }
}
