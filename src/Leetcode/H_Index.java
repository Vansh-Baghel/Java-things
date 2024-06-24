package Leetcode;

import java.util.*;

public class H_Index {
    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        System.out.println(hIndex(arr));
    }
    static int hIndex(int[] citations) {
        int n = citations.length, res = 0;

        Arrays.sort(citations);
        reverse(citations, n - 1);

        for (int i = 0; i < n; i++) {
            if (citations[i] >= i + 1) res = i;
            else break;
        }

        return res;
    }

    private static void reverse(int[] citations, int e) {
        int s = 0;

        while (s < e){
            int temp = citations[s];
            citations[s] = citations[e];
            citations[e] = temp;
            s++;
            e--;
        }
    }
}
