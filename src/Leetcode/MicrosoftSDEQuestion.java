package Leetcode;

import java.util.Arrays;

//A patient needs rehabilitation within the next N days (numbered from 0 to N-1). The rehabilitation consists of X sessions. For every rehabilitation session, other than the last one, the next session is exactly Y days later.
//
//        You are given an array A of N integers listing the costs of the individual rehabilitation sessions on the N days: that is rehabilitation on the K-th day costs A[K].
//
//        Write a function:
//
//        def solution(A, X, Y)
//
//        that, given the array A and the two integers X and Y, returns the minimum cost of
//
//        rehabilitation.
//
//        It is guaranteed that it is always possible to complete all X rehabilitation sessions.
//
//        Examples:
//
//        1. Given A=[4,2,3, 71, X=2 and Y=2, your function should return 7, which is the sum
//
//        of the costs on days 0 and 2 (7=4+3).
//
//        2. Given A=[10,3,4, 71, X=2 and Y=3, your function should return 17 since rehabilitation is possible only on days 0 and 3 (17=10+7).
//
//        3. Given A=[4,2,5,4,3,5,1,4,2, 71, X-3 and Y = 2, your function should return 6, which is the sum of the costs on days 4, 6 and 8 (6=3+1+2).
//
//        Write an efficient algorithm for the following assumptions:
//
//        N and X are integers within the range [2.200,000); each element of array A is an integer within the range [1..1,000);• Y is an integer within the range [1..199,999); •Nis higher than (X-1)*Y.

public class MicrosoftSDEQuestion {
    public static void main(String[] args) {
        int[] A= {10,3,4,7};
        int X=2, Y=3;
        int ans = getMinimum3(A, X, Y);
        System.out.println(ans);
    }

    private static int getMinimum(int[] arr, int x, int y) {
        int n = arr.length;
        return findCount(arr, n-1, x-1, y);
    }

    private static int findCount(int[] arr, int idx, int count, int diff) {
        if (count == 0) return arr[idx];
        if (idx < 0) return (int)1e9;

        int pick = Integer.MAX_VALUE;
        if (idx-diff >= 0) pick = arr[idx] + findCount(arr, idx-diff, count-1, diff);
        int notPick = findCount(arr, idx-1, count, diff);
        return Math.min(pick, notPick);
    }

    private static int getMinimum2(int[] arr, int x, int y) {
        int n = arr.length;
        int[][] dp = new int[n][x+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return findCount2(arr, n-1, x-1, y, dp);
    }

    private static int findCount2(int[] arr, int idx, int count, int diff, int[][] dp) {
        if (count == 0) return arr[idx];
        if (idx < 0) return (int)1e9;

        if (dp[idx][count] != -1) return dp[idx][count];

        int pick = Integer.MAX_VALUE;
        if (idx-diff >= 0) pick = arr[idx] + findCount2(arr, idx-diff, count-1, diff, dp);
        int notPick = findCount2(arr, idx-1, count, diff, dp);
        return dp[idx][count] = Math.min(pick, notPick);
    }

    private static int getMinimum3(int[] arr, int x, int y) {
        int n = arr.length;
        int[][] dp = new int[n][x+1];
        int diff = y;

        for(int row[]: dp)
            Arrays.fill(row,(int)1e9);

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int cnt = 1; cnt <= x; cnt++) {
                int pick = Integer.MAX_VALUE;
                if (idx-diff >= 0) pick = arr[idx] + dp[idx-diff][cnt-1];
                int notPick = dp[idx-1][cnt];
                dp[idx][cnt] = Math.min(pick, notPick);
            }
        }
        return dp[n-1][x-1];
    }
}
