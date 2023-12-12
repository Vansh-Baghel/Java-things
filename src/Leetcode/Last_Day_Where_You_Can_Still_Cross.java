package Leetcode;

public class Last_Day_Where_You_Can_Still_Cross {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int s = 0, e = row - 1, res = 0;

        while (s <= e){
            int m = s + (e - s) / 2;

            if (canCross(row, col, m, cells)){
                res = m;
                s = m + 1;
            } else e = m - 1;
        }

        return res;
    }

    public int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean canCross(int row, int col, int m, int[][] cells) {
        int[][] mat = new int[row][col];

        for (int i = 0; i < m; i++) {
            mat[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        for (int c = 0; c < col; c++) {
            if (mat[0][c] == 0 && dfs(mat, 0, c)) return true;
        }

        return false;
    }

    public boolean dfs(int[][] mat, int r, int c) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] == 1) return false;

        // Means we are on the last row.
        if (r == mat.length - 1) return true;

        mat[r][c] = 1;

        for(int[] dir: dirs){
            int row = dir[0] + r;
            int col = dir[1] + c;

            if (dfs(mat, row, col)){
                return true;
            }
        }

        return false;
    }
}
