package Leetcode;

public class Maximum_Sum_Problem {
    public int maxSum2(int n) {
        //code here.
        if (n <= 10) return n;
        return Math.max(n/2 + n/3 + n/4, solve(n));
    }

    public int solve(int n) {
        if (n <= 0) return 0;
        if (n == 2) return 2;
        if (n == 1 || n == 3 || n == 4) return n;

        int a1 = Math.max(n/2, solve(n/2));
        int a2 = Math.max(n/3, solve(n/3));
        int a3 = Math.max(n/4, solve(n/4));

        return a1 + a2 + a3;
    }

    public int maxSum(int n) {
        //code here.
        if (n == 0 || n == 1) return n;

        return Math.max(n, maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4));
    }
}
