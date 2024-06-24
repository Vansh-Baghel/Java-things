package Leetcode;

public class Special_Positions_in_a_Binary_Matrix {
    static int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length, cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1){
                    if (isSpecial(i, j, n, m, mat)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean isSpecial(int row, int col, int n, int m, int[][] mat) {

        for (int i = 0; i < n; i++) {
            if (i != row && mat[i][col] == 1) return false;
        }
        for (int i = 0; i < m; i++) {
            if (i != col && mat[row][i] == 1) return false;
        }

        return true;
    }


    static int numSpecial2(int[][] mat) {
        int n = mat.length, m = mat[0].length, res = 0;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (row[i] == 1 && col[j] == 1) res++;
                }
            }
        }

        return res;
    }
}
