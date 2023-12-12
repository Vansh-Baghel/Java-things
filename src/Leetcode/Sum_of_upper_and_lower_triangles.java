package Leetcode;

import java.util.*;

public class Sum_of_upper_and_lower_triangles {
    public static void main(String[] args) {
        int N = 3;
        int mat[][] = {{6, 5, 4},
            {1, 2, 5},
            {7, 9, 7}};

        System.out.println(sumTriangles(mat, N));
    }
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int lower = 0, upper =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j){
                    lower += matrix[i][j];
                } else if (i < j){
                    upper += matrix[i][j];
                }
                else {
                    lower += matrix[i][j];
                    upper += matrix[i][j];
                }
            }
        }

        ans.add(upper);
        ans.add(lower);
        return ans;
    }
}
