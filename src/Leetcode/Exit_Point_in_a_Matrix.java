package Leetcode;

public class Exit_Point_in_a_Matrix {
    public static void main(String[] args) {

    }

    int[] ans = new int[2];
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int i = 0, j = 0;

        return solve(i, j, n, m, -1, -1, 'R', matrix);
    }

    public  int[] solve(int i, int j, int n, int m, int prevRow, int prevCol, char dir, int[][] mat){
        if (i >= n || j >= m || i < 0 || j < 0) {
            ans[0] = prevRow;
            ans[1] = prevCol;
            return ans;
        }

        if (mat[i][j] == 0){
            if (dir == 'L') solve(i, j - 1, n, m, i, j, dir, mat);
            else if (dir == 'R') solve(i, j + 1, n, m, i, j, dir, mat);
            else if (dir == 'D') solve(i + 1, j, n, m, i, j, dir, mat);
            else if (dir == 'U') solve(i - 1, j, n, m, i, j, dir, mat);
        } else {
            mat[i][j] = 0;
            if (dir == 'L') solve(i-1, j, n, m, i, j, 'U', mat);
            else if (dir == 'R') solve(i + 1, j, n, m, i, j, 'D', mat);
            else if (dir == 'D') solve(i, j - 1, n, m, i, j, 'L', mat);
            else if (dir == 'U') solve(i, j + 1, n, m, i, j, 'R', mat);
        }

        return ans;
    }
}
