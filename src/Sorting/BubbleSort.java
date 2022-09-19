package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,1,5,9,2,12,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
//            j must go from 1 to arr.length - i because j starts from 1.
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j- 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
