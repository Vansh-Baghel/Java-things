package Leetcode.Contest;

public class Naughty_Geek {
    public static long totalWays(int N) {
        // code here
        if (N <= 2) return N;

        return N * totalWays(N - 1);
    }
}
