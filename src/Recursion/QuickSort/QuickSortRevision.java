package Recursion.QuickSort;

import java.util.*;

public class QuickSortRevision {
    public static void main(String[] args) {
        int[] arr = {4 ,1 ,3 ,9, 7};
        quickSort(arr , 0 , arr.length - 1 );
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex+1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot = low;
        int i = low;
        int j = high;

        while(i < j){
            while (arr[i] <= arr[pivot] && i < high){
                i++;
            }
            while (arr[j] >= arr[pivot] && j > low){
                j--;
            }
            if (i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        // Need to return j because that is the index with which we are swapping the pivot.
        return j;
    }

    static void swap(int arr[], int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
