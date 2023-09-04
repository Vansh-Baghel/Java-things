package Leetcode.Contest;

import java.util.*;

public class Odd_Triplets {
//    long countTriplet(int N, int A[],int X) {
//        long ans = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = i+1; j < N; j++) {
//                for (int k = j+1; k < N; k++) {
//                    if (checkOdd(A[i]) && checkOdd(A[j]) && checkOdd(A[k])){
//                        if (X <= j - i && X <= k - j) ans++;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//
//    boolean checkOdd(int num){
//        return num % 2 == 1;
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        long ans = countTriplet(4,arr , 1);
        System.out.println(ans);
    }

    static long countTriplet(int N, int A[],int X) {
        List<Integer> odd = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 1){
                // adding indices in odd.
                odd.add(i);
            }
        }

        int m = odd.size();
        int i = 0;
        int[] firstValidI = new int[m];
        int[] firstValidK = new int[m];

        for (int j = 0; j < m; j++) {
            firstValidI[j] = -1;

            if (odd.get(j) - odd.get(i) >= X){
                while (odd.get(j) - odd.get(i) >= X){
                    i++;
                }
                i--;

                firstValidI[j] = i;
            }
        }

        int k = m - 1;

        for (int j = m-1; j >= 0; j--) {
            firstValidK[j] = -1;

            if (odd.get(k) - odd.get(j) >= X){
                while (odd.get(k) - odd.get(j) >= X){
                    k--;
                }
                k++;

                firstValidK[j] = k;
            }
        }

        for (int j = 0; j < m; j++) {
            if (firstValidI[j] != -1 && firstValidK[j] != -1){
                ans = ans + (firstValidI[j] + 1) * (m-firstValidK[j]);
            }
        }
        return ans;
    }
}
