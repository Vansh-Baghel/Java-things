package Sorting;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,2};
        int ans = duplicateNum(arr);
        System.out.println(ans);
    }

    static int duplicateNum(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
        return -1;
    }


    static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}
