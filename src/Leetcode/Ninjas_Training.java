package Leetcode;

import java.util.Arrays;

public class Ninjas_Training {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };

        int ans = ninjaTraining3(3, matrix);
        System.out.println(ans);
    }

    // Using recursion
    public static int ninjaTraining(int n, int points[][]) {
        int[] maxPoints = new int[1];
        // We are passing 3, since length of col will always be 3. It will not mark anything as last since 0 index based hai, so it will be 0,1,2.

        return maxPointsTraining(points, n - 1, 3);
    }

    private static int maxPointsTraining(int[][] points, int idx, int last) {
        int maxi = 0;

        if (idx == 0) {
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[idx][i]);
                }
            }
            return maxi;
        }

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[idx][i] + maxPointsTraining(points, idx - 1, i);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }

    // Using dp: Memoization
    public static int ninjaTraining2(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return maxPointsTraining2(points, n - 1, 3, dp);
    }

    private static int maxPointsTraining2(int[][] points, int idx, int last, int[][] dp) {
        int maxi = 0;
        if (dp[idx][last] != -1) return dp[idx][last];

        if (idx == 0) {
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[idx][i]);
                }
            }
            return dp[idx][last] = maxi;
        }

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[idx][i] + maxPointsTraining2(points, idx - 1, i, dp);

                // maxi is changing with the for loop iteration.
                maxi = Math.max(maxi, point);
            }
        }

        return dp[idx][last] = maxi;
    }

    // Using dp: Tabular
    public static int ninjaTraining3(int n, int points[][]) {
        int dp[][] = new int[n][4];

        // Base condition
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));

        // We wont be using idx - 1 k alawa any row of dp, eg if idx = 2, dp of row 1 hee will be needing. dp of 0th row is waste.
        for (int idx = 1; idx < n; idx++) {
            for (int last = 0; last < 4; last++) {
                dp[idx][last] = 0;

                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int point = points[idx][i] + dp[idx - 1][i];
                        dp[idx][last] = Math.max(dp[idx][last], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    // Optimized approach
    public static int ninjaTraining4(int n, int points[][]) {
        // We dont need full dp 2D array, each time we just need idx - 1 wala dp row. So maintaining a single row for this would do the work.
        // We require this till n + 1 because 0 based indexing hojati hai
        int prevList[] = new int[4];

        // Base condition
        prevList[0] = Math.max(points[0][1], points[0][2]);
        prevList[1] = Math.max(points[0][0], points[0][2]);
        prevList[2] = Math.max(points[0][1], points[0][0]);
        prevList[3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));

        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;

                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int point = points[idx][i] + prevList[i];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prevList = temp;
        }
        return prevList[3];
    }
}
