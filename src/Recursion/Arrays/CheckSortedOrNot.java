package Recursion.Arrays;

public class CheckSortedOrNot {
    public static void main(String[] args) {
        int[] nums = {1, 8 , 6 };
        System.out.println(isSorted(nums , 0));
    }

    static boolean isSorted(int[] nums, int i) {
        if (i == nums.length - 1){
            return true;
        }

//        If either first condition is false then it will return false without even checking further . And the first condition compares the two adjacent numbers.
        return nums[i] < nums[i + 1] && isSorted(nums , i + 1);
    }

}
