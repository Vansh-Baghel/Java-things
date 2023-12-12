package Leetcode;

public class Minimize_Maximum_of_Array {
    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }

    static int minimizeArrayValue(int[] nums) {
        int s = 0, e = Integer.MIN_VALUE, result = 0;

        for (int num : nums) {
            e = Math.max(e, num);
        }

        while (s <= e){
            int m = s + (e - s) / 2;

            if (!greaterExists(nums, m)) s = m + 1;
            else {
                result = m;
                e = m - 1;
            }
        }

        return result;
    }

    private static boolean greaterExists(int[] nums, int m) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > m) return false;

            long buffer = m - arr[i];
            arr[i+1] -= buffer;
        }

        return arr[n - 1] <= m;
    }
}
