package Leetcode;

public class MAXIMUM_SUM_OF_DIAGONAL {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(findMaxDiagonalSum(matrix));
    }

    private static int findMaxDiagonalSum(int[][] arr) {
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        int m = arr[0].length;

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            maxi = getDiagonalCnt(arr, 0, i, n,m, cnt, maxi);
        }

        for (int i = 0; i < n; i++) {
            maxi = getDiagonalCnt(arr, i, 0, n,m, cnt, maxi);
        }

        return maxi;
    }

    private static int getDiagonalCnt(int[][] arr, int r, int c, int n, int m, int cnt, int maxi) {
        if (r == n || c == m) return maxi;

        cnt += arr[r][c];
        if (maxi < cnt) maxi = cnt;
        return getDiagonalCnt(arr, r + 1, c+1,n,m,cnt, maxi);
    }
}
