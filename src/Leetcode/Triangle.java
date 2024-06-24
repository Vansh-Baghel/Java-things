package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        int[][] array = {
                {-1},
                {2, 3},
                {1, -1, -3}
        };

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(2));
        matrix.add(Arrays.asList(3, 4));
        matrix.add(Arrays.asList(6, 5, 7));
        matrix.add(Arrays.asList(4, 1, 8, 3));

        int ans = minimumTotal(matrix);
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

        for (int i = 0; i < n; i++) {
            nxt[i] = triangle[n-1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] cur = new int[n];

            for (int j = i; j >= 0; j--) {
                int left = nxt[j] + triangle[i][j];
                int right = nxt[j+1] + triangle[i][j];

                cur[j] = Math.min(left, right);
            }
            nxt=cur;
        }
        return nxt[0];
    }



















    static int minimumTotal(List<List<Integer>> triangle) {
        // First row will only have 1 num, it is given in the question.
        return minSteps(triangle.size(), 0, 0, triangle);
    }

    static int minSteps(int size, int r, int c, List<List<Integer>> triangle) {
        if (r == size - 1) return triangle.get(r).get(c);

        int pickCur = triangle.get(r).get(c) + minSteps(size, r+1, c, triangle);
        int pickNxt = triangle.get(r).get(c) + minSteps(size, r+1, c+1, triangle);

        return Math.min(pickNxt, pickCur);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] r: dp) Arrays.fill(r, -1);
        return minSteps(triangle.size(), 0, 0, triangle, dp);
    }

    static int minSteps(int size, int r, int c, List<List<Integer>> triangle, int[][] dp) {
        if (r == size - 1) return triangle.get(r).get(c);

        if (dp[r][c] != -1) return dp[r][c];

        int pickCur = triangle.get(r).get(c) + minSteps(size, r+1, c, triangle, dp);
        int pickNxt = triangle.get(r).get(c) + minSteps(size, r+1, c+1, triangle, dp);

        return dp[r][c] = Math.min(pickNxt, pickCur);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int r = n - 2; r >= 0; r--) {
            for (int c = r; c >= 0; c--) {
                int pickCur = triangle.get(r).get(c) + dp[r+1][c];
                int pickNxt = triangle.get(r).get(c) + dp[r+1][c+1];

                dp[r][c] = Math.min(pickNxt, pickCur);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] cur = new int[n], nxt = new int[n];

        for (int i = 0; i < n; i++) {
            nxt[i] = triangle.get(n - 1).get(i);
        }

        for (int r = n - 2; r >= 0; r--) {
            for (int c = r; c >= 0; c--) {
                int pickCur = triangle.get(r).get(c) + nxt[c];
                int pickNxt = triangle.get(r).get(c) + nxt[c+1];
                cur[c] = Math.min(pickNxt, pickCur);
            }
            nxt = cur;
        }

        return nxt[0];
    }
}
