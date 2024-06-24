package Leetcode;

public class Maximum_sum_of_hour_glass {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        if (n < 3 || m < 3) return -1;

        int res = 0;

        for (int r = 0; r < n - 2; r++){
            for (int c = 0; c < m - 2; c++){
                int sum = 0;
                for (int i = c; i < c + 3; i++){
                    sum+=mat[r][i];
                    sum+=mat[r + 2][i];
                }
                sum += mat[r + 1][c + 1];
                res=Math.max(sum, res);
            }
        }

        return res;
    }
}
