package Leetcode.Contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimise_The_Distance {
    public static void main(String[] args) {
        int[] arr = {7, 4, 8, 2, 7, 5, 8, 5};
        System.out.println(minimumDis(arr.length, arr));
    }

    public static int minimumDis(int N, int[] X) {
        // code here
        int res = Integer.MAX_VALUE, mini = Integer.MAX_VALUE;

        for (int i = N - 1; i >= 0; i--){
            int curSum = 0;
            for (int j = N - 1; j >= 0; j--){
                curSum += Math.abs(X[j] - X[i]);
            }

            if (mini >= curSum){
                mini = curSum;
                res = X[i];
            }
        }

        return res;
    }
}
