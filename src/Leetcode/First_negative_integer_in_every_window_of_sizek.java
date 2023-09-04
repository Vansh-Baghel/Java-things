package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class First_negative_integer_in_every_window_of_sizek {
    public static void main(String[] args) {
        long arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        long[] ans = printFirstNegativeInteger(arr, arr.length, 3);
        System.out.println(Arrays.toString(ans));
    }

    static long[] printFirstNegativeInteger(long A[], int N, int K) {
            Queue<Integer> q = new LinkedList<>();
            long[] ans = new long[N - K + 1];
            for (int i = 0; i < N; i++) {
                if (A[i] < 0) q.add(i);
            }

            for (int i = 0; i < N - K + 1; i++) {
                if (!q.isEmpty() && q.peek() < i) q.poll();
                // checking with the size of the end of the window.
                if (!q.isEmpty() && i+K-1 >= q.peek()) {
                    ans[i] = A[q.peek()];
                }
                else ans[i] = 0;
            }
            return ans;
    }
}
