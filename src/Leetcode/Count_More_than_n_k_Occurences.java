package Leetcode;

import java.util.Arrays;

public class Count_More_than_n_k_Occurences {
    public static void main(String[] args) {

    }
    static int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        int res = 0, minOccurrence = n/k, s = 0;
        Arrays.sort(arr);

        for (int e = 1; e < n; e++) {
            if (arr[e] == arr[e-1]) continue;
            else {
                if (e - s > minOccurrence) res++;
                s = e;
            }
        }

        if (n - s > minOccurrence) res++;

        return res;
    }
}
