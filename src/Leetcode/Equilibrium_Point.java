package Leetcode;

public class Equilibrium_Point {
    public static void main(String[] args) {
        long[] arr = {8, 8, 3, 7, 8, 2, 7, 2};
        System.out.println(equilibriumPoint(arr,8));
    }
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) return 1;
        if (n == 0) return -1;

        long totalSum = 0;
        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            long el = arr[i];
            long halfSum = (totalSum - el)/2;
            if (leftSum == halfSum) return i+1;

            leftSum += arr[i];
        }
        return -1;
    }
}
