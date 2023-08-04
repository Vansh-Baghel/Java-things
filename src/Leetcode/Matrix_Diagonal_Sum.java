package Leetcode;

public class Matrix_Diagonal_Sum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println(diagonalSum(mat));

    }

    static int diagonalSum(int[][] mat) {
        int ans = 0;
        int diagFromBack = mat[0].length - 1;

        for (int i = 0 ; i < mat.length ; i++){
            for (int j = 0 ; j < mat[0].length ; j++){
                if (i == j) ans += mat[i][j];
                if (i == j && j == diagFromBack) continue;
                else if (j == diagFromBack){
                    ans += mat[i][j];
                    diagFromBack--;
                }
            }
        }
        return ans;
    }
}
