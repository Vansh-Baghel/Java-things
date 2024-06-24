package Leetcode;

public class Element_Appearing_More_Than_25_In_Sorted_Array {
    static int findSpecialInteger(int[] arr) {
        int n = arr.length, k = n / 4, s = 0;

        if (n % 4 != 0) k++;

        for (int e = 1; e < n; e++) {
            if (arr[e] == arr[s]){
                return arr[s];
            }

            if ((e - s) + 1 == k) {
                s++;
            }
        }

        return -1;
    }
}
