package Leetcode;

import java.util.Arrays;

public class Count_the_elements {
    public static void main(String[] args) {
        int[] a = {7, 8, 10, 9, 10, 10, 7};
        int[] b = {9, 3, 10, 4, 6, 6, 7};
        int n = 4;
        int[] query = {2, 5, 4, 1};
        int q = 4;

        System.out.println(Arrays.toString(countElements(a,b,n,query,q)));
    }

    public static int[] countElements(int a[], int b[], int n, int query[], int q){
        int[] res = new int[q];
        Arrays.sort(b);

        for (int i = 0; i < q; i++){
            int cnt = solve(b, a[query[i]]);
            res[i] = cnt;
        }
        return res;
    }

    public static int solve(int[] b, int tar){
        int s = 0, e = b.length - 1, pos = 0;

        while (s <= e){
            int m = (s + e) / 2;

            if (b[m] <= tar){
                pos = m + 1;
                s = m + 1;
            } else e = m - 1;
        }

        return pos;
    }
}
