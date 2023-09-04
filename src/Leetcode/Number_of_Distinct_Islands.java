package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Number_of_Distinct_Islands {
    static class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

    int countDistinctIslands(int[][] grid) {
        HashSet<ArrayList<Integer>> hs = new HashSet<>();

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int sum = 0;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<ArrayList<Pair>> res = new ArrayList<>();
                ArrayList<Integer> list = new ArrayList<>();

                if (!vis[i][j] && grid[i][j] == 1){
                    int baseR = i;
                    int baseC = j;
                    dfs(i, j, vis, grid, delrow, delcol, list, baseR, baseC);
                    hs.add(list);
                }
            }
        }
        return hs.size();
    }

    static void dfs(int row, int col,  boolean vis[][], int mat[][], int delrow[], int delcol[], ArrayList<Integer> list, int baseR, int baseC) {

        if (row < 0 || row > mat.length - 1 || col < 0 || col > mat[0].length - 1 || mat[row][col] == 0) return;

        if (!vis[row][col]) {
            vis[row][col] = true;
            int subR = row - baseR;
            int subC = col - baseC;
            list.add(subR);
            list.add(subC);
        }
        else return;

        dfs(row -1, col, vis, mat, delrow, delcol, list, baseR, baseC );
        dfs(row + 1, col, vis, mat, delrow, delcol, list, baseR, baseC );
        dfs(row , col - 1, vis, mat, delrow, delcol, list, baseR, baseC );
        dfs(row , col + 1, vis, mat, delrow, delcol, list, baseR, baseC );
    }
}
