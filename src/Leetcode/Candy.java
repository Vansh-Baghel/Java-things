package Leetcode;

import java.util.Arrays;

public class Candy {
    static int minCandy(int N, int ratings[]) {
        int[] L2R = new int[N];
        int[] R2L = new int[N];

        Arrays.fill(L2R , 1);
        Arrays.fill(R2L , 1);

        int res = 0;

        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                L2R[i] = L2R[i - 1] + 1;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                R2L[i] = R2L[i + 1] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            res += Math.max(L2R[i], R2L[i]);
        }

        return res;
    }

    static int minCandy2(int N, int ratings[]) {
        int[] count = new int[N];

        Arrays.fill(count , 1);

        int res = 0;

        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = Math.max(count[i - 1] + 1, count[i]);
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i + 1] + 1, count[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            res += count[i];
        }

        return res;
    }
}
