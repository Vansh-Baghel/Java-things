package Leetcode;
import java.lang.reflect.Array;
import java.util.*;

public class Nth_Tribonacci_Number {
    public static void main(String[] args) {
        System.out.println(tribonaci3(4));
    }

    public int tribonacci(int n) {
        int[] arr;
        arr = new int[40];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1] + arr[i];
        }
        return arr[n];
    }

    static int tribonacci2(int n) {
        return fn(n);
    }

    private static int fn(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;

        return fn(n - 1) + fn(n - 2) + fn(n - 3);
    }

    static int tribonaci3(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}

