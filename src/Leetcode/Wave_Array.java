package Leetcode;

public class Wave_Array {
    public static void convertToWave(int n, int[] a) {
        for (int i = 0; i < n; i+=2) {
            if (i + 1 < n) swap(i, i+1, a);
            else continue;
        }
    }

    private static void swap(int idx1, int idx2, int[] a) {
        int temp = a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=temp;
    }
}
