package Leetcode;

import java.util.Arrays;

public class Subset_Sum_Equal_To_K {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] arr2 = {2, 5, 1, 6, 7};
        System.out.println(subsetSumToK3(4,5,arr));
    }

    // Using recursion
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return isPresent(n-1,k,arr);
    }

    private static boolean isPresent(int idx, int target, int[] arr) {
        if (target == arr[idx]) return true;
        if (idx == 0) return arr[0] == target;

        boolean left = false;
        if (target > arr[idx]) left = isPresent(idx - 1, target - arr[idx], arr);
        boolean right = isPresent(idx - 1, target, arr);
        return left || right;
    }

    // Using dp: Memoization
    public static boolean subsetSumToK2(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for (int[] row: dp){
            Arrays.fill(row, -1);
        }
        return isPresent2(n-1,k,arr, dp);
    }

    private static boolean isPresent2(int idx, int target, int[] arr, int[][] dp) {
        if (target == arr[idx]) return true;
        if (idx == 0) return arr[0] == target;

        if (dp[idx][target] != -1) return dp[idx][target]==0?false:true;

        boolean left = false;
        if (target > arr[idx]) left = isPresent2(idx - 1, target - arr[idx], arr, dp);
        boolean right = isPresent2(idx - 1, target, arr, dp);
        dp[idx][target] = left || right ? 1 : 0;
        return left || right;
    }

    // Using dp: Tabulation
    public static boolean subsetSumToK3(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(arr[0]<=k) dp[0][arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            for(int target= 1; target<=k; target++){
                boolean left = false;
                if (target >= arr[idx]) left = dp[idx - 1][target - arr[idx]];
                boolean right = dp[idx - 1][target];
                dp[idx][target] = left || right;
            }
        }
        return dp[n-1][k];
    }

    // Using Optimized
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
}
