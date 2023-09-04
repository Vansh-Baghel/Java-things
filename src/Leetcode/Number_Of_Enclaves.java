package Leetcode;

public class Number_Of_Enclaves {
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int sum = 0;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            if(!vis[0][i] && grid[0][i] == 1){
                dfs(0, i, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i, 0, vis, grid, delrow, delcol);
            }
        }
        for (int i = 0; i < m; i++) {
            if(!vis[n-1][i] && grid[n-1][i] == 1){
                dfs(n-1, i, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(i, m-1, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1){
                    sum++;
                }
            }
        }

        return sum;
    }

    static void dfs(int row, int col, boolean vis[][], int mat[][], int delrow[], int delcol[]) {

        if (row < 0 || row > mat.length - 1 || col < 0 || col > mat[0].length - 1 || mat[row][col] == 0) return;

        if (!vis[row][col]) vis[row][col] = true;
        else return;

        dfs(row -1, col, vis, mat, delrow, delcol);
        dfs(row + 1, col, vis, mat, delrow, delcol);
        dfs(row , col - 1, vis, mat, delrow, delcol);
        dfs(row , col + 1, vis, mat, delrow, delcol);
    }
}
