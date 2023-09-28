package Leetcode;

import java.util.Arrays;

public class Stickler_Thief {
    public static void main(String[] args) {
        int[] arr = {6, 5, 5, 7, 4};
        System.out.println(FindMaxSum3(arr, 5));
    }

    static int FindMaxSum(int arr[], int n){
        return getMax(arr, n-1);
    }

    static int getMax(int[] arr, int n) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];

        int pick = arr[n] + getMax(arr, n-2);
        int notPick = getMax(arr, n-1);
        return Math.max(pick, notPick);
    }

    static int FindMaxSum2(int arr[], int n){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMax2(arr, n-1, dp);
    }

    static int getMax2(int[] arr, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];

        if (dp[n] != -1) return dp[n];

        int pick = arr[n] + getMax2(arr, n-2, dp);
        int notPick = getMax2(arr, n-1, dp);
        return dp[n] = Math.max(pick, notPick);
    }

    static int FindMaxSum3(int arr[], int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int pick = arr[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}
