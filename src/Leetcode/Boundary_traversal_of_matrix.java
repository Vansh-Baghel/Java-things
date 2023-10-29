package Leetcode;

import java.util.ArrayList;

public class Boundary_traversal_of_matrix {
    public static void main(String[] args) {
        int matrix[][] = {{3}, {8}, {2}};

        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println(boundaryTraversal(matrix, n, m));
    }

    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m){
        ArrayList<Integer> ans = new ArrayList<>();

        // Because if 1D matrix hua toh m-2 or n-2 will run again which will print the loop again. Therefore add a condition or run this loop.
//        if (m == 1 || n == 1) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    ans.add(matrix[i][j]);
//                }
//            }
//            return ans;
//        }


        for (int i = 0; i < m; i++) {
            ans.add(matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            ans.add(matrix[i][m-1]);
        }
        if (m > 1) for (int i = m-2; i >= 0; i--) {
            ans.add(matrix[n-1][i]);
        }
        if (n > 1) for (int i = n-2; i > 0; i--) {
            ans.add(matrix[i][0]);
        }

        return ans;
    }
}
