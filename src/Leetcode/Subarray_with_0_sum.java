package Leetcode;

import java.util.HashSet;

public class Subarray_with_0_sum {
    static boolean findsum(int arr[],int n){
        int[] prefix = new int[n];
        HashSet<Integer> hs = new HashSet<>();

        prefix[0] = arr[0];
        hs.add(0);
        hs.add(prefix[0]);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            if (hs.add(prefix[i])) hs.add(prefix[i]);
            else return true;
        }

        return false;
    }

    static boolean findsum2(int arr[],int n) {
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;

        hs.add(0);

        for (int num: arr){
            sum += num;
            if(hs.add(sum)) hs.add(sum);
            else return true;
        }

        return false;
    }
}
