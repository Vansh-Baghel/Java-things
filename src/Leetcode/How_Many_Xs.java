package Leetcode;

public class How_Many_Xs {
    int countX(int L, int R, int X) {
        // L + 1 because question says excluding it
        int res = 0;

        for (int i = L+1; i < R; i++) {
            int n = i;

            while (n > 0) {
                int rem = n % 10;
                if (rem == X) res++;
                n /= 10;
            }
        }

        return res;
    }
}
