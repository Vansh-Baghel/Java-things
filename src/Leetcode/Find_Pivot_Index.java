package Leetcode;

public class Find_Pivot_Index {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }

    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i+1];
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) return i;
        }
        return -1;
    }
}
