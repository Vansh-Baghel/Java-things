package Leetcode;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // d is direction
        int d = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        // While condition is such so that values dont repeat of overlap within a loop.
        while (top <= bottom && left <= right){
            // If any of these if conditions become true, it would go to last step where d = (d+ 1) % 4 is there where we are increasing the value of d.

            // Left to right
            if (d == 0){
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            }
            // Top to Bottom
            else if (d == 1){
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }
            //  Right to Left
            else if (d == 2){
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Bottom to Top
            else if (d == 3){
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            d=(d+1)%4;
        }
        return list;
    }
}