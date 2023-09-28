package Leetcode;

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int a = 1, b = 2, c = 1;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
