//https://leetcode.com/problems/set-matrix-zeroes/
package Leetcode;

public class Set_Matrix_Zeros {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1} , {1,0,1} , {1,1,1}};
        setZeroes(arr);
    }
    static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
//        Ofc if any row has some length then all rows will have same length.
        int cols = matrix[0].length;

//        Used to check if in given matrix does 1st col contain 0 or not , because other elements will convert the 1st col elements as 0 which eventually will convert the whole 1st col as 0 which we dont want.
        int col0 = 1;

        for (int i = 0; i < rows; i++) {
//            If any of the element from 1st col is 0 in given matrix , only then we have to set full col 1 as 0 . Because other elements which are 0 will set 1st col k elements as 0 .
                if (matrix[i][0] == 0) {
                    col0 = 0;
                }
//                Check from 2nd col otherwise if we check from 1st col then it will make all the other elements in the 1st row as 0 because mat[0][0] will become 0 if any of the elements from 1st col is 0.
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = rows - 1 ; i >= 0 ; i--) {
            for (int j = cols - 1 ; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
//            If col0 = 0 then everytime when col loop gets over , make the 1st element of different rows as 0,
            if (col0 == 0){
                matrix[i][0] = 0;
            }
        }
        }
    }

