package Leetcode;

import java.util.Arrays;

public class Print_matrix_in_diagonal_pattern {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(Arrays.toString(matrixDiagonally(mat)));
    }

    static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length, i = 0, j = 0, idx = 0, cnt = 0;
        int[] res = new int[n * n];
        boolean up = true;

            while (cnt < n * n) {
            // Up
            if (up){
                while (i >= 0 && j < n){
                    res[idx++] = mat[i][j];
                    cnt++;

                    if (j == n - 1) {
                        i++;
                        break;
                    } else if (i == 0){
                        // If aur right nhi ja skte, toh neeche chale jaao
                        if (j == n - 1) i++;
                        else j++;
                        break;
                    }

                    i--;
                    j++;
                }

                up=false;
            } else {
                while (i < n && j >= 0){
                    res[idx++] = mat[i][j];
                    cnt++;

                    if (j == 0){
                        // if i last index par hai, toh cannot go down, therefore move right
                        if (i == n - 1) j++;
                        else i++;
                        break;
                    } else if (i == n - 1) {
                        j++;
                        break;
                    }
                    i++;
                    j--;
                }

                up=true;
            }
        }

        return res;
    }
}
