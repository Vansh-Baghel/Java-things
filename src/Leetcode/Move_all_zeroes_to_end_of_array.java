package Leetcode;

import java.util.Arrays;

public class Move_all_zeroes_to_end_of_array {
    public static void main(String[] args) {
        int[] arr = {0,0,1,2,3,0,4,5};
        int n = arr.length;
        pushZerosToEnd(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    static void pushZerosToEnd(int[] arr, int n) {
            // code here
        int s = 0;
        for (int e = s; e < n; e++) {
            if (arr[e] != 0){
                swap(s, e, arr);
                s++;
            }
        }
    }

    static void swap(int i, int idx, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}
