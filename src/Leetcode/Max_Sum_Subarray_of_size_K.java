package Leetcode;

import java.util.*;

public class Max_Sum_Subarray_of_size_K {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        // code here
        int s = 0;
        long maxi = 0, sum = 0;

        for (int e = 0; e < N; e++) {
            sum += Arr.get(e);

            if ((e - s) + 1 == K){
                maxi = Math.max(sum, maxi);
                sum -= Arr.get(s++);
            }
        }

        return maxi;
    }
}
