package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] array = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        int ans = minimumPathSum4(array, 4);
        System.out.println(ans);
    }

    // Using renxtsion
    public static int minimumPathSum(int[][] triangle, int n) {
        return minSum(triangle, n, 0, 0);
    }

    static int minSum(int[][] triangle, int n, int row, int col) {
        if (row == n - 1) return triangle[row][col];

        int left = minSum(triangle, n, row + 1, col) + triangle[row][col];
        int right = minSum(triangle, n, row + 1, col + 1) + triangle[row][col];

        return Math.min(left, right);
    }

    // Using dp: Tabulation- (Renxtsion use krliya, so not good since SC will be O(N)+O(N))
    public static int minimumPathSum2(int[][] triangle, int n) {
        int dp[][]=new int[n][n];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return minSum2(triangle, n, 0, 0, dp);
    }

    static int minSum2(int[][] triangle, int n, int row, int col, int[][] dp) {
        if (row == n - 1) return triangle[row][col];

        if(dp[row][col]!=-1) return dp[row][col];

        int left = minSum2(triangle, n, row + 1, col, dp) + triangle[row][col];
        int right = minSum2(triangle, n, row + 1, col + 1, dp) + triangle[row][col];

        return dp[row][col] = Math.min(left, right);
    }

    public static int minimumPathSum3(int[][] triangle, int n) {
        int dp[][]=new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int left = dp[i+1][j] + triangle[i][j];
                int right = dp[i+1][j+1] + triangle[i][j];

                dp[i][j] = Math.min(left, right);
            }
        }
        return dp[0][0];
    }

    public static int minimumPathSum4(int[][] triangle, int n) {
        int[] nxt=new int[n];
        int[] cur=new int[n];

        for (int i = 0; i < n; i++) {
            nxt[i] = triangle[n-1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int left = nxt[j] + triangle[i][j];
                int right = nxt[j+1] + triangle[i][j];

                cur[j] = Math.min(left, right);
            }
            nxt=cur;
        }
        return nxt[0];
    }
}
