//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/
package Leetcode;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] n = {6,8,9,2,3,5};
        System.out.println(search(n , 6));
    }

//    Explanation: - https://www.youtube.com/watch?v=yM-6NO4_rR8
    static boolean search(int[] nums,int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e){
        int m = s + (e-s)/2;

        if (nums[m] == target){
            return true;
        }

//        Less work because if those are , then its a direct answer. One condition must be in mind before using this . Dup elements elimination must be down because if the array has 1 length then it will go out of bound .
        if (nums[s] == target || nums[e] == target){
            return true;
        }

//        Eliminate the duplicates.
        if (nums[m] == nums[s] && nums[m] == nums[e]){
            ++s;
            --e;
        }

//        Here mid is greater than start.
        else if (nums[s] <= nums[m]){
//            Check if the target is greater than start and smaller than mid . If it is , then left side else target lies on right side.
            if (nums[s] < target && nums[m] > target){
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

//      Here mid is smaller than start.
        else{
//            If end > target and mid < target then it definitely means that it lies on the right side. If nums = {7,9,1,2,3,4,5} then the mid is 2 , so dont assume that all elements on left of mid are greater than mid . To tackle this problem , we used else statement which makes e as m - 1.
            if (nums[e] > target && nums[m] < target){
                s = m + 1;
            }
            else {
                e = m - 1;
            }
        }
        }
        return false;
    }
}
