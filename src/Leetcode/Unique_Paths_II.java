package Leetcode;

import java.util.*;

public class Unique_Paths_II {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        // First row
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        row1.add(0);
        mat.add(row1);

        // Second row
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(-1);
        row2.add(0);
        mat.add(row2);

        // Third row
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);
        mat.add(row3);

        int ans = mazeObstacles2(3,3, mat);
        System.out.println(ans);
    }


    //     With recursion
    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        return totalPaths(n-1,m-1,mat);
    }

    private static int totalPaths(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        if (mat.get(n).get(m) == -1) return 0;
        if (m == 0 && n == 0) return 1;
        int left = 0;
        int right = 0;
        if (n != 0) left = totalPaths(n-1, m, mat);
        if (m != 0) right = totalPaths(n, m-1, mat);

        return left+right;
    }

    //     With recursion: Memoization
    static int mazeObstacles2(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);

        // Because 0 indexing hoga toh 3,3 will create 4,4 matrix
        return totalPaths2(n-1,m-1,mat, dp);
    }

    static int totalPaths2(int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (mat.get(n).get(m) == -1) return 0;
        if (m == 0 && n == 0) return 1;

        if (dp[n][m] != -1) return dp[n][m];
        int left = 0;
        int right = 0;
        if (n != 0) left = totalPaths2(n-1, m, mat, dp);
        if (m != 0) right = totalPaths2(n, m-1, mat, dp);

        return dp[n][m] = left+right;
    }

    // Using dp: Space Optimization
    static int mazeObstacles3(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[] prev= new int[m];
        int[] cur = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = 1;
                    continue;
                }
                if (mat.get(i).get(j) == -1) {
                    cur[j] = 0;
                    continue;
                }

                int up = 0;
                int left = 0;

                if(i>0) up = prev[j];
                if(j>0) left = cur[j-1];

                cur[j] = up + left;
            }
            prev=cur;
        }
        return cur[m-1];
    }
}
