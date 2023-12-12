package Leetcode;

import java.util.Arrays;

public class Frequencies_of_Limited_Range_Array_Elements {
    public static void main(String[] args) {
        int[] a = {8,9};
        int N = a.length;
        int P = 5;

        frequencyCount(a, N, P);
        System.out.println(Arrays.toString(a));
    }
    static void frequencyCount(int arr[], int N, int P) {
        // code here
        for (int i = 0; i < N; i++) {
            while (arr[i] > 0){
                if (arr[i] > N) {
                    arr[i] = 0;
                    break;
                }
                int curNum = arr[i];

                if (arr[i] > N) break;
                if (arr[arr[i] - 1] > 0) {
                    curNum-=1;
                    arr[i] = -1;
                    swap(i, curNum, arr);
                } else{
                    arr[i] = 0;
                    arr[curNum - 1]--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] *= -1;
        }
    }

    private static void swap(int i, int i1, int[] arr) {
        int t = arr[i];
        arr[i] = arr[i1];
        arr[i1] = t;
    }
}
