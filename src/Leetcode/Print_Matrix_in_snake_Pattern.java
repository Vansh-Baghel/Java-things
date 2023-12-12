package Leetcode;

import java.util.*;

public class Print_Matrix_in_snake_Pattern {
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < m; j++) {
                    ans.add(matrix[i][j]);
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
