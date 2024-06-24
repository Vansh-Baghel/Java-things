package Leetcode;

import java.util.*;

public class Out_of_Boundary_Paths {
    public static void main(String[] args) {
        System.out.println(findPaths2(2,2,2,0,0));
    }

    public static int res = 0;
    public static int[] drow = {-1,1,0,0};
    public static int[] dcol = {0,0,-1,1};

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        for (int i = 1; i <= maxMove; i++){
            solve(i, m, n, startRow, startColumn);
        }

        int t = res;
        res = 0;
        return t;
    }

    public static void solve (int max, int m, int n, int row, int col){
        if (max < 1) return;
        if (row < 0 || col < 0 || row >= m || col >= n) return;

        for (int i = 0; i < 4; i++){
            int r = row + drow[i], c = col + dcol[i];

            if (max == 1) {
                if (r < 0 || c < 0 || r >= m || c >= n) res++;
            } else {
                solve(max - 1, m, n, r, c);
            }
        }
    }

    public static int mod = 1000000000 + 7;

    public static int findPaths2(int m, int n, int maxMove, int r, int c) {
        long[][][] dp = new long[51][51][51];

        for (long[][] row: dp){
            for (long[] col: row) Arrays.fill(col, -1);
        }

        // Time complexity: O(4^maxMove) because harr ek move par 4 moves lagg rhe hai
        return (int)solve(m, n, maxMove, r, c, dp);
    }

    public static long solve (int m, int n, int max, int r, int c, long[][][] dp){
        if (r < 0 || c < 0 || r >= m || c >= n) return 1L;
        if (max <= 0) return 0;

        if (dp[r][c][max] != -1) return dp[r][c][max];

        long top = solve(m, n, max - 1, r - 1, c, dp), down = solve(m, n, max - 1, r + 1, c, dp);
        long left = solve(m, n, max - 1, r, c - 1, dp) % mod, right = solve(m, n, max - 1, r, c + 1, dp);

        return dp[r][c][max] = (top + down + left + right) % mod;
    }


    public static int findPaths3(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[51][51][51];
        int[][] directions = {{-1,0}, {1, 0}, {0,-1}, {0, 1}};
        int mod = 1000000000 + 7;

        // Time complexity: O(maxMove*m*n), same is the space for the dp.
        for (int max = 1; max <= maxMove; max++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir: directions){
                        int row = dir[0] + r, col = dir[1] + c;
                        if (row < 0 || col < 0 || row >= m || col >= n) dp[r][c][max] = (dp[r][c][max] + 1) % mod;
                        else dp[r][c][max] = (dp[r][c][max] + dp[row][col][max-1]) % mod;
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }
}
