package Leetcode;

import java.util.Arrays;

public class Sort_The_Array {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3};
        System.out.println(Arrays.toString(sortArr(arr, arr.length)));
    }

   static int[] sortArr(int[] arr, int n){
        // code here
        for (int i = 0; i < n; i++){
            for (int j = i; j >= 1; j--){
                if (arr[j] < arr[j - 1]) {
                    swap(j, j-1, arr);
                } else break;
            }
        }

        return arr;
    }

    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
