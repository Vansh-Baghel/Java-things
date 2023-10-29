package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Factorial_Sum {
    public static void main(String[] args) {
        int factorial = fact(5);
        int addingRange = add(5);
        System.out.println(factorial);
        System.out.print(addingRange);
    }

    static int add(int n) {
        if (n <= 1){
            return 1;
        }
        return n + add(n - 1);
    }

    static int fact(int n){
//      factorial of 1 is 1 , therefore it must be the base condition from where all the factorials will be transferred.
        if (n <= 1){
            return 1;
        }

        return n * fact(n - 1);
    }

    static int factorial2(int N){
        //code here
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);

        return findFact2(N, dp);
    }

    private static int findFact2(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] != -1) return dp[n];

        return dp[n] = n * findFact2(n - 1, dp);
    }

    static int factorial3(int N){
        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2]=2;

        for (int i = 3; i <= N; i++) {
            dp[i] = i * dp[i - 1];
        }

        return dp[N];
    }
}
