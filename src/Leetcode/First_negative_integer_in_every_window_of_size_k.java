package Leetcode;

import java.util.*;

public class First_negative_integer_in_every_window_of_size_k {
    static long[] printFirstNegativeInteger(long A[], int N, int K) {
        int s = 0, idx = 0;
        Queue<Long> q = new LinkedList<>();
        long[] res = new long[N-(K-1)];

        for (int e = 0; e < N; e++) {
            if (A[e] < 0) q.add(A[e]);

            if ((e - s) + 1 == K){
                if (!q.isEmpty()) {
                    res[idx++] = q.peek();
                } else res[idx++] = 0;

                if (A[s] < 0){
                    q.poll();
                }

                s++;
            }
        }

        return res;
    }
}
