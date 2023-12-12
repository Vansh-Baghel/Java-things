package Leetcode;

public class Peak_Index_in_a_Mountain_Array {
    static int peakIndexInMountainArray(int[] arr) {
        int s = 1, n = arr.length, e = n - 1;

        while (s <= e){
            int m = s + (e-s) / 2;

            if (arr[m] > arr[m+1] && arr[m] > arr[m-1]){
                return m;
            } else if (arr[m] < arr[m+1]) s = m + 1;
            else e = m - 1;
        }

        return -1;
    }
}
