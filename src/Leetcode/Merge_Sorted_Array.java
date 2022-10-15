//https://leetcode.com/problems/merge-sorted-array/
package Leetcode;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {

    }

    //    Explanation: - https://www.youtube.com/watch?v=C4oBXLr3zos
    static void merge(int[] nums1, int m, int[] nums2, int n) {
//         p1 and p2 will return the last elements of both the array . For nums1 it will return the last element which is not 0 .
        int p1 = m - 1;
        int p2 = n - 1;
//        i will point the last value of nums1 .
        int i = m + n - 1;
//         We will check the conditions till nums[2] length .
        while (p2 >= 0) {
//      if p1 is smaller than 0 then dont check it because it will be out of bound being -1.
            if (p1 >= 0 && nums1[p1] < nums2[p2]) {
//             i-- is same as i=i-1.
                nums1[i--] = nums2[p2--];
            }
//             means nums1 wala value is greater.
            else {
                nums1[i--] = nums1[p1--];
            }

        }
    }
}




//    static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[n - i - 1];
//        }
//        quickSort(nums1, 0, nums1.length - 1);
//        System.out.println(Arrays.toString(nums1));
//    }

//    static void quickSort(int[] arr, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//
//        int s = low;
//        int e = high;
//        int m = s + (e - s) / 2;
//        int pivot = arr[m];
//
//        while (s <= e) {
//            while (arr[s] < pivot) {
//                s++;
//            }
//            while (arr[e] > pivot) {
//                e--;
//            }
//            if (s <= e) {
//                int temp = arr[s];
//                arr[s] = arr[e];
//                arr[e] = temp;
//                s++;
//                e--;
//            }
//        }
//        quickSort(arr, low, e);
//        quickSort(arr, s, high);
//    }

