package Leetcode;

public class Replace_O_with_X {
    public static void main(String[] args) {
        char[][] pattern = {
                {'X', 'X', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O'}
        };

        char[][] ans = fill(4,5,pattern);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+", ");
            }
            System.out.println();
        }
    }
    static char[][] fill(int n, int m, char a[][]) {
        boolean[][] vis = new boolean[n][m];
        char[][] ans = new char[n][m];
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            if(!vis[0][i] && a[0][i] == 'O'){
                dfs(0, i, vis, a, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if(!vis[i][0] && a[i][0] == 'O'){
                dfs(i, 0, vis, a, delrow, delcol);
            }
        }
        for (int i = 0; i < m; i++) {
            if(!vis[n-1][i] && a[n-1][i] == 'O'){
                dfs(n-1, i, vis, a, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if(!vis[i][m-1] && a[i][m-1] == 'O'){
                dfs(i, m-1, vis, a, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]){
                    ans[i][j] = 'O';
                } else ans[i][j] = 'X';
            }
        }

        return ans;
    }

    static void dfs(int row, int col, boolean vis[][], char mat[][], int delrow[], int delcol[]) {

        if (row < 0 || row > mat.length - 1 || col < 0 || col > mat[0].length - 1 || mat[row][col] == 'X') return;

        if (!vis[row][col]) vis[row][col] = true;
        else return;

        dfs(row -1, col, vis, mat, delrow, delcol);
        dfs(row + 1, col, vis, mat, delrow, delcol);
        dfs(row , col - 1, vis, mat, delrow, delcol);
        dfs(row , col + 1, vis, mat, delrow, delcol);
    }
}
