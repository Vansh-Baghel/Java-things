package Leetcode;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int N = arr.length;
        System.out.println(matrixMultiplication(arr, N));
    }
    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
        return findMinimum(1, N-1, arr);
    }

    private static int findMinimum(int idx, int n, int[] arr) {
        if (idx == n) return 0;
        int mini = Integer.MAX_VALUE;

        for (int k = idx; k < n; k++) {
            int steps = arr[idx-1] * arr[k] * arr[n] + findMinimum(idx, k, arr) + findMinimum(k + 1, n, arr);
            if (steps < mini) mini = steps;
        }
        return mini;
    }

    public static int matrixMultiplication2(int[] arr , int N) {
        // Write your code here
        int[][] dp = new int[N][N];
        for (int[] r : dp) Arrays.fill(r, -1);
        return findMinimum2(1, N-1, arr, dp);
    }

    private static int findMinimum2(int idx, int n, int[] arr, int[][] dp) {
        if (idx == n) return 0;

        if (dp[idx][n] != -1) return dp[idx][n];

        int mini = Integer.MAX_VALUE;

        for (int k = idx; k < n; k++) {
            int steps = arr[idx-1] * arr[k] * arr[n] + findMinimum2(idx, k, arr, dp) + findMinimum2(k + 1, n, arr, dp);
            if (steps < mini) mini = steps;
        }
        return dp[idx][n] = mini;
    }

    public static int matrixMultiplication3(int[] arr , int N) {
        // Write your code here
        int[][] dp = new int[N][N];
        for (int idx = N - 1; idx >= 1; idx--) {
            for (int n = idx + 1; n < N; n++) {
                int mini = Integer.MAX_VALUE;
                for (int k = idx; k < n; k++) {
                    int steps = arr[idx-1] * arr[k] * arr[n] + dp[idx][k] + dp[k + 1][n];
                    if (steps < mini) mini = steps;
                }
                dp[idx][n] = mini;
            }
        }
        return dp[1][N - 1];
    }
}
