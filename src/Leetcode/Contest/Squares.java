//https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-123/problems
package Leetcode.Contest;

public class Squares {
    int squares(int N, int X) {
        long side = (int)(Math.pow(2, N));
        long maxSides = side * side;

        if (X > maxSides) return -1;

        // X-- because we already have 1 box initially.
        X--;

        // At each step, the boxes will increase by 3. Because 1 box is broken and 4 are formed.
        // Therefore totalFormed = 4 - 1 ie 3.
        int ans = X / 3;

        // This because if X = 10, and N = 3, then it will increase by 1 -> 4 -> 7 -> 9 -> 12, therefore 1 more than 9/3.
        if (X % 3 != 0) ans++;

        return ans;
    }
}
