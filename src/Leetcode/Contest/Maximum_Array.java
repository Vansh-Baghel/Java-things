package Leetcode.Contest;

import java.util.Arrays;

public class Maximum_Array {
    public static int solve(int N, int a, int[] x) {
        // code here
        int maxi = 0;
        Arrays.sort(x);

        for (int i = 0; i < 2; i++){
            maxi = Math.max(maxi, Math.abs(x[i] - a) + Math.abs(x[N - 1 - i] - a));
        }

        maxi = Math.max(maxi, Math.abs(a - x[1]) + Math.abs(a - x[0]));
        maxi = Math.max(maxi, Math.abs(a - x[N - 1]) + Math.abs(a - x[N-2]));

        return maxi;
    }
}
