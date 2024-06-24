package Leetcode;

import java.util.Arrays;

public class Minimum_Difficulty_of_a_Job_Schedule {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        System.out.println(minDifficulty(arr, 2));
    }

    static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (d > n) return -1;

        return findMin(0, n, d, jobDifficulty);
    }

    private static int findMin(int idx, int n, int d, int[] jobDifficulty) {
        // If 1 hee dinn bacha hai toh check amongst all the aage k elements.
        if (d == 1) {
            int maxi = jobDifficulty[idx];

            for (int i = idx; i < n; i++) {
                maxi = Math.max(maxi, jobDifficulty[i]);
            }

            return maxi;
        }

        int maxi = 0;
        int res = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxi = Math.max(maxi, jobDifficulty[i]);
            int cur_res = maxi + findMin(i+1, n, d - 1, jobDifficulty);
            res = Math.min(res, cur_res);
        }

        return res;
    }

    static int minDifficulty2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (d > n) return -1;
        int[][] dp = new int[n][d+1];

        for (int[] r: dp) Arrays.fill(r, -1);

        return findMin(0, n, d, jobDifficulty, dp);
    }

    private static int findMin(int idx, int n, int d, int[] jobDifficulty, int[][] dp) {
        // If 1 hee dinn bacha hai toh check amongst all the aage k elements.
        if (d == 1) {
            int maxi = jobDifficulty[idx];

            for (int i = idx; i < n; i++) {
                maxi = Math.max(maxi, jobDifficulty[i]);
            }

            return maxi;
        }

        if (dp[idx][d] != -1) return dp[idx][d];

        int maxi = 0;
        int res = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxi = Math.max(maxi, jobDifficulty[i]);
            int cur_res = maxi + findMin(i+1, n, d - 1, jobDifficulty, dp);
            res = Math.min(res, cur_res);
            dp[idx][d] = res;
        }

        return res;
    }
}
