package Leetcode;

import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        int ans = uniquePaths4(3,3);
        System.out.println(ans);
    }

//     With recursion
    public static int uniquePaths(int m, int n) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        return totalPaths(m-1,n-1);
    }

    private static int totalPaths(int m, int n) {
        if (m == 0 && n == 0) return 1;
        int left = 0;
        int right = 0;
        if (m != 0) left = totalPaths(m-1, n);
        if (n != 0) right = totalPaths(m, n-1);

        return left+right;
    }

//     Using dp: Using memoization
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        return totalPaths2(m-1,n-1, dp);
    }

    private static int totalPaths2(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return 1;

        if (dp[m][n] != -1) return dp[m][n];

        int left = 0;
        int right = 0;
        if (m != 0) left = totalPaths2(m-1, n, dp);
        if (n != 0) right = totalPaths2(m, n-1, dp);

        dp[m][n] = left+right;
        return left+right;
    }

    // Using dp: Tabular form
    public static int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                int right = 0;
                if (i > 0) left = dp[i-1][j];
                if (j > 0) right = dp[i][j-1];

                if (i == 0 && j == 0) dp[0][0] = 1;
                else dp[i][j] = left+right;
            }
        }

        return dp[m-1][n-1];
    }

    // Using dp: Space Optimization
    public static int uniquePaths4(int m, int n) {
        // Using only cur, little confusing
//        int[] cur = new int[n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0) {
//                    cur[j] = 1;
//                }
//
//                // cur[j] + cur[j-1] will give the addition of current num, and of the previous num, ie, current col ka num & prev row ka num.
//                // Dono left and right ek hee mai we are adding.
//                else if(j > 0) cur[j] += cur[j-1];
//            }
//        }

        // Better to understand.
        int[] prev= new int[n];
        int[] cur = new int[n];

        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                up = prev[j];
                if(j>0) left = cur[j-1];

                cur[j] = up + left;
            }
            prev=cur;
        }
        return cur[n-1];
    }
}
