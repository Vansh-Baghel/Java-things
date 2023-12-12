package Leetcode;

import java.util.*;

public class Spirally_traversing_a_matrix {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c){
        ArrayList<Integer> ans = new ArrayList<>();
        int top = 0, bottom = r-1, left = 0, right = c-1, dir = 0;

        // dir is for matrices where r != c
        // dir will make sure that when the matrix is completed traversing, then no other num is printed.
        // It will recheck the while condition after every one operation.
        // Dry run the example: r = 3, c = 5, mat = 6 6 2 28 2 12 26 3 28 7 22 25 3 4 23

        while (top <= bottom && left <= right){
            if (dir == 0){
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            }

            if (dir == 1){
                for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
                }
            right--;
            }

            if (dir == 2){
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;

            }

            if (dir == 3){
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir++;

            if (dir == 4) dir = 0;
        }
        return ans;
    }
}
