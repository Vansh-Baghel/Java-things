package Leetcode;

import java.util.Arrays;

public class Shuffle_integers {
    public static void main(String[] args) {
        int n = 4;
        long[] arr = {1, 2, 9, 15};
        shuffleArray(arr, n);
    }

    static void shuffleArray(long arr[], int n){
        for (int i = 1; i < n - 1; i++) {
            long curNum = arr[i];
            long curPos = i;
            int mid = n / 2;

            while (curNum > 0) {
                long newPos;

                if (curPos < mid){
                    newPos = 2 * curPos;
                } else newPos = 2 * (curPos-mid) + 1;

                long newNum = arr[(int)newPos];
                arr[(int)newPos] = -curNum;
                curNum = newNum;
                curPos = newPos;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) arr[i] *= -1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
