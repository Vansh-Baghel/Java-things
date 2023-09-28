package Leetcode;

import java.util.Arrays;

public class Count_number_of_hops {
    public static void main(String[] args) {
        System.out.println(countWays3(5));
    }
    static long countWays(int n){
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;

        return countWays(n - 1) + countWays(n - 2) + countWays(n-3);
    }

    static long countWays2(int n){

        if (n <= 2) return n;

        long[] dp = new long[n+1];
        int mod = (int)1e9 + 7;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%mod;
        }
        return dp[n];
    }

    static long countWays3(int n){

        if (n <= 2) return n;
        int mod = (int)1e9 + 7;

        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        return countTotal(n, dp, mod);
    }

    private static long countTotal(int n, long[] dp, int mod) {
        if (dp[n] != -1) return dp[n];

        return dp[n] = (countTotal(n - 1, dp, mod) + countTotal(n - 2, dp, mod) + countTotal(n-3, dp, mod)) % mod;
    }
}
