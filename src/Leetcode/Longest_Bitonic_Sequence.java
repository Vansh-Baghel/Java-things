package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Longest_Bitonic_Sequence {
    public static void main(String[] args) {
        int[] arr = {1,3,5,3,1};
        int n = arr.length;
        System.out.println(longestBitonicSequence(arr, n));
    }
    static int longestBitonicSequence(int[] arr, int n) {
        int maxi = 0;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (arr[prev] < arr[idx] && dp1[prev] + 1 > dp1[idx]){
                    dp1[idx] = dp1[prev] + 1;
                }
            }
        }

        for (int idx = n-1; idx >= 0; idx--) {
            for (int prev = idx; prev < n; prev++) {
                if (arr[prev] < arr[idx] && dp2[prev] + 1 > dp2[idx]){
                    dp2[idx] = dp2[prev] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi , dp1[i] + dp2[i]);
        }

        return maxi - 1;
    }
}
