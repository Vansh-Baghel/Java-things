package Leetcode;

import java.util.Arrays;

public class Chocolate_Pickup {
    public static void main(String[] args) {
        int[][] array = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int ans = maximumChocolates2(3,4,array);
        System.out.println(ans);
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        return maxCount(0, 0, c-1, r, c, grid);
    }

    private static int maxCount(int i, int j1, int j2, int r, int c, int[][] grid) {
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return (int)(Math.pow(-10, 9));

        if (i >= r-1){
            if (j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        int maxi= (int)(Math.pow(-10, 9));
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int ans = 0;
                    if (j1 == j2) ans= grid[i][j1] + maxCount(i+1,j1+d1,j2+d2, r,c,grid);
                    else ans= grid[i][j1] + grid[i][j2] + maxCount(i+1,j1+d1,j2+d2, r,c,grid);
                    maxi = Math.max(ans, maxi);
            }
        }
        return maxi;
    }
    public static int maximumChocolates2(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int row1[][]: dp) {
            for (int row2[]: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return maxCount2(0, 0, c-1, r, c, grid, dp);
    }

    private static int maxCount2(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return (int)(Math.pow(-10, 9));

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if (i >= r-1){
            if (j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi= (int)(Math.pow(-10, 9));
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int ans = 0;
                    if (j1 == j2) ans= grid[i][j1] + maxCount2(i+1,j1+d1,j2+d2, r,c,grid, dp);
                    else ans= grid[i][j1] + grid[i][j2] + maxCount2(i+1,j1+d1,j2+d2, r,c,grid, dp);
                    maxi = Math.max(ans, maxi);
                dp[i][j1][j2] = maxi;
            }
        }
        return dp[i][j1][j2];
    }

    public static int maximumChocolates3    (int n, int m, int[][] grid) {
        int dp[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        //Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    //Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}
