package Leetcode.Contest;

public class Count_the_Number_of_Incremovable_Subarrays_II {
    public static void main(String[] args) {
        int[] n = {5,5,6};
        System.out.println(incremovableSubarrayCount(n));
    }

    static long incremovableSubarrayCount(int[] nums) {
        long res = 0;
        int n = nums.length, firstLowest = 0, lastLowest = n - 1;

        // Finding first and last lowest.
        while (firstLowest + 1 < n && nums[firstLowest] < nums[firstLowest + 1]) firstLowest++;
        while (lastLowest - 1 >= 0 && nums[lastLowest] > nums[lastLowest - 1]) lastLowest--;
        if (firstLowest != n - 1) {
            res += (n - lastLowest + 1);

            for (int i = 0; i <= firstLowest; i++) {
                while (lastLowest < n && nums[i] >= nums[lastLowest]) lastLowest++;
                res += (n - lastLowest + 1);
            }
        } else {
            return (long)n * (n + 1) / 2;
        }

        return res;
    }
}
