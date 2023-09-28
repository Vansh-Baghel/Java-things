package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        int[] dp = new int[6 + 1];
        Arrays.fill(dp, -1);

        int[] dp2 = new int[6 + 1];
        dp2[0] = 0;
        dp2[1] = 1;

        int result = fib4(6, dp2);
        System.out.println(result);
    }

    // Fibonacci without recursion
    // Space complexity: O(1)
    static int fib(int n) {
        int a = 0, b = 1, c = 1;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // With recursion
    static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        return fib2(n - 1) + fib2(n - 2);
    }

    // Using Memoization => Top to Down, means tree k top se will go down.
    // With dp: SC: O(N) + O(N) => 1 for recursion and 1 for array
    static int fib3(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return dp[n] = fib3(n - 1, dp) + fib3(n - 2, dp);
    }

    // With dp: SC: O(N) => 1 for array

    static int fib4(int n, int[] dp2) {
        for (int i = 2; i <= n; i++) {
            dp2[i] = dp2[i-1]+ dp2[i-2];
        }
        return dp2[n];
    }

}