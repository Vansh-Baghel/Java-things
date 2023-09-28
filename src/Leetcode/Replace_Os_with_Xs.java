package Leetcode;

public class Replace_Os_with_Xs {
    static char[][] fill(int n, int m, char a[][]) {
        boolean[][] vis = new boolean[n][m];
        char[][] mat = new char[n][m];

        for (int row = 0; row < n; row++) {
            if (a[row][0] == 'O' && !vis[row][0]){
                dfs(row, 0, vis, a, n, m);
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i][m-1] == 'O' && !vis[i][m-1]){
                dfs(i, m-1, vis, a, n, m);
            }
        }
        for (int j = 0; j < m; j++) {
            if (a[0][j] == 'O' && !vis[0][j]){
                dfs(0, j, vis, a, n, m);
            }
        }
        for (int j = 0; j < m; j++) {
            if (a[n-1][j] == 'O' && !vis[n-1][j]){
                dfs(n-1, j, vis, a, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]){
                    mat[i][j] = 'O';
                } else mat[i][j] = 'X';
            }
        }

        return mat;
    }

    private static void dfs(int row, int col, boolean[][] vis, char[][] a, int n, int m) {
        vis[row][col] = true;
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};

        for (int i = 0; i < 4; i++) {
            int nrow = drow[i] + row;
            int ncol = dcol[i] + col;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && a[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis,a,n,m);
            }
        }
    }
}
