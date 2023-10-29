package Leetcode;

public class Boolean_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {0, 0, 0},
        };

        booleanMatrix(matrix);
    }
    static void booleanMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && matrix[i][j] == 1){
                    rowColTrue(matrix, vis, i, j, n, m);
                }
            }
        }

//        for(int[] r : matrix){
//            for(int c : r){
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
    }

    private static void rowColTrue(int[][] matrix, boolean[][] vis, int r, int c, int n, int m) {
        for (int i = 0; i < m; i++) {
            if (matrix[(r)][i] == 0){
                vis[r][i] = true;
                matrix[r][i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][c] == 0){
                vis[i][c] = true;
                matrix[i][c] = 1;
            }
        }
    }


    static void booleanMatrix2(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] rowArr = new int[n];
        int[] colArr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1){
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            if (rowArr[row] == 1){
                // Converting the whole row to 1.
                for (int it = 0; it < m; it++) {
                    matrix[row][it] = 1;
                }
            }
        }

        for (int col = 0; col < m; col++) {
            if (colArr[col] == 1){
                for (int it = 0; it < n; it++) {
                    matrix[it][col] = 1;
                }
            }
        }
    }
}
