package Leetcode.Contest;

import java.util.Arrays;

public class sum {
    public static int Solve(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];
        for (int[] r: dp) Arrays.fill(dp, -1);
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                res += slv(i, j, j + 1, j + 1, n, S, dp);
            }
        }

        return res;
    }

    public static int slv(int a, int b, int x, int y, int n, String s, int[][] dp) {
        if (x >= n || y >= n || x > y)
            return 0;

        if (dp[x][y] != 0)
            return dp[x][y];

        StringBuilder str = new StringBuilder();
        str.append(s.substring(a, b + 1));
        str.append(s.substring(x, y + 1));

        int leftIncrease = isPalindrome(str) ? 1 + slv(a, b, x + 1, y, n, s, dp) : slv(a, b, x + 1, y, n, s, dp);
        int rightIncrease = slv(a, b, x, y + 1, n, s, dp);

        dp[x][y] = leftIncrease + rightIncrease;
        return dp[x][y];
    }

    public static boolean isPalindrome(StringBuilder str) {
        // System.out.println(str.toString());
        return str.toString().equals(str.reverse().toString());
    }

    public static void main(String[] args) {
        int result = Solve("abb");
        System.out.println(result);
    }
}
