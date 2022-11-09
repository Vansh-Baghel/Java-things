//https://leetcode.com/problems/search-insert-position/
package Leetcode;

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums , 4));
    }
    static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int s = 0;
        int e = nums.length - 1;

//        Let it go till s = e
        while (s <= e){
            int m = s + (e - s)/2;
            if (nums[m] == target){
                return m;
            }
            else if (nums[m] < target){
                s = m + 1;
            }
            else {
                e = m - 1;
            }
        }
//        If nothing returns from the while loop then it means that your start is already ahead than end , and it will always be the ans.
            return s;
    }
}
