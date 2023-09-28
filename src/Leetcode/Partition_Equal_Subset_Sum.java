package Leetcode;

public class Partition_Equal_Subset_Sum {
    public static boolean subsetSumToK4(int n, int k, int arr[]) {
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;

        if(arr[0]<=k) prev[arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            boolean[] cur = new boolean[k + 1];
            cur[0] = true;

            for(int target= 1; target<=k; target++){
                boolean left = false;
                if (target >= arr[idx]) left = prev[target - arr[idx]];
                boolean right = prev[target];
                cur[target] = left || right;
            }
            prev=cur;
        }
        return prev[k];
    }

    public static boolean canPartition(int[] arr, int n) {
        // Write your code here.
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum+= arr[i];
        }

        // Means odd sum hua toh false hee hoga
        if (totalSum % 2 != 0) return false;

        int k = totalSum/2;
        return subsetSumToK4(n, k, arr);
    }
}
