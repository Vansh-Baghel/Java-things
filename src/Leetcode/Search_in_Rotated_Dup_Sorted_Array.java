//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
package Leetcode;

public class Search_in_Rotated_Dup_Sorted_Array {    public static void main(String[] args) {
    int[] n = {3,4,5,6,1,2};
    System.out.println(search(n , 2));
    }

    static boolean search(int[] nums,int target) {
        int pivot = findPivot(nums);
        if (pivot == -1){
            binarySearch(nums , target , 0 , nums.length - 1);
        }
        if (nums[pivot] == target){
            return true;
        }

        if (nums[0] <= target){
            return binarySearch(nums , target , 0 , pivot - 1);
        }
        return binarySearch(nums ,target , pivot + 1 , nums.length - 1);
    }

    static boolean binarySearch(int[] nums, int t, int s, int e) {
        while (s <= e){
            int m = s + (e-s)/2;
            if (nums[m] == t){
                return true;
            }
            if (nums[m] <= t){
                return binarySearch(nums, t , m + 1 , e);
            }
            else {
                 return binarySearch(nums, t , s , m - 1);
            }
        }
        return false;
    }

    static int findPivot(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

//        Here we found the index of pivot.
        while (s <= e){
            int m = s + (e-s) / 2;
//            So that (m - 1) must not be -1 .
            if (m > s && nums[m] < nums[m - 1]){
                return m - 1;
            }
//            So that (m + 1) must not exceed the last element of the array .
            if (m < e && nums[m] > nums[m + 1]){
                return m;
            }
            if (nums[s] <= nums[m]){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }
        return -1;
    }
}
