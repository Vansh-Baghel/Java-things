//https://leetcode.com/problems/set-matrix-zeroes/
package Leetcode;

import java.util.Arrays;

public class Set_Matrix_Zeros {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1} , {1,0,1} , {1,1,1}};
        setZeroes2(arr);
    }
    static void setZeroes(int[][] matrix) {
        // Better than Brute force.
        // Time complexity : O((m * n) + (m + n * no. of 1) + (n + m * no. of 1))
        // Space complexity : O(n + m)
        // int rowLength = matrix.length;
        // int colLength = matrix[0].length;

        // int[] outerRow = new int[rowLength];
        // int[] outerCol = new int[colLength];

        // for (int i = 0 ; i < rowLength; i++){
        //     for (int j= 0 ; j < colLength ; j++){
        //         if (matrix[i][j] == 0){
        //             outerRow[i] = 1;
        //             outerCol[j] = 1;
        //         }
        //     }
        // }

        // for (int i = 0 ; i < outerRow.length ; i++){
        //     if (outerRow[i] == 1){
        //         for (int j = 0 ; j < matrix[0].length; j++){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // for (int i = 0 ; i < outerCol.length ; i++){
        //     if (outerCol[i] == 1){
        //         for (int j = 0 ; j < matrix.length; j++){
        //             matrix[j][i] = 0;
        //         }
        //     }
        // }

        // Optimal Sol
        // Time complexity: O(m * n + (m - 1) * (n - 1) + m + n) ie O(2 * m * n)
        // Space complexity : O(1)
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int col0 = 1;

        for (int i = 0 ; i < rowLength; i++){
            for (int j= 0 ; j < colLength ; j++){
                if (matrix[i][j] == 0 && j != 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                } else if (matrix[i][j] == 0 && j == 0) col0 = 0;
            }
        }

        // First mark 0 to the elements which are not at 0th position
        for (int i = 1 ; i < rowLength; i++){
            for (int j = 1 ; j < colLength ; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        // If there exist any 0 in first row then m[0][0] would already by 0 by the very first loop, and if there are any 0 in first col then col0 would already be 0.
        // Therefore convert this separately because if we dont, and by any case if m[0][0] is converted to 0, then it will affect other rows as well.
        if (matrix[0][0] == 0) {
            for (int j = 0 ; j < colLength ; j++){
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0 ; i < rowLength ; i++){
                matrix[i][0] = 0;
            }
        }
    }

    static void setZeroes2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (row[i] == 0){
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (col[i] == 0){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}

