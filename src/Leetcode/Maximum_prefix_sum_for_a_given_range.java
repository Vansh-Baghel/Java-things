package Leetcode;

import java.util.*;

public class Maximum_prefix_sum_for_a_given_range {
    public static void main(String[] args) {
        long a[] = {-1, 2, 3, -5};
        long[] l = {0,1}, r = {3,3};
        long n = a.length, q = l.length;
        long[] nums = maxPrefixes(a, l, r, n, q);

        for (long num: nums) System.out.print(num + " ");
    }
    static long[] maxPrefixes(long a[], long L[], long R[], long N, long Q) {
        long[] ans = new long[(int)Q];
        long[] prefixArr = new long[(int)N];

        for (int i = 0; i < Q; i++) {
            ans[i] = getMax(a, prefixArr, (int) L[i], (int) R[i]);
        }

        return ans;
    }

    private static long getMax(long[] a, long[] prefixArr, int s, int e) {
        long maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = s; i <= e; i++) {
            sum += a[i];
            prefixArr[i] = sum;
            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }

//    static void formPrefixArray(long[] a, long[] prefixArr, long n) {
//        for (int i = 1; i < n; i++) {
//            prefixArr[i] = prefixArr[i-1] + a[i];
//        }
//    }

}
