package Sorting;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3};
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion_sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
//                Note:- The if statement is between j and j - 1 & not j and i.
                if (arr[j] < arr[j - 1]){
                    swap(arr , j, j - 1 );
                }
//                It'll break the condition if the previous number is not greater because all the numbers behind it will be sorted so theres no meaning to check them.
                else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int j, int behindJ) {
        int temp = arr[j];
        arr[j] = arr[behindJ];
        arr[behindJ] = temp;
    }
}
