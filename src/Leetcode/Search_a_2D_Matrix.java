package Leetcode;

public class Search_a_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int row = findRow(n, matrix, target);

        return isPresent(row, m, matrix, target);
    }

    private static boolean isPresent(int row, int n, int[][] matrix, int target) {
        int s = 0, e = n - 1;

        while (s <= e){
            int m = s + (e - s)/2;

            if (matrix[row][m] > target) e = m - 1;
            else if (matrix[row][m] < target) s = m + 1;
            else return true;
        }

        return false;
    }

    private static int findRow(int n, int[][] matrix, int target) {
        int s = 0, e = n - 1, possible = 0;

        while (s <= e){
            int m = s + (e - s)/2;

            if (matrix[m][0] > target){
                e = m - 1;
            } else {
                possible = m;
                s = m + 1;
            }
        }

        return possible;
    }
}
