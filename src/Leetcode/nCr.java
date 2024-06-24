package Leetcode;

import java.util.*;

public class nCr {
    public static void main(String[] args) {
        System.out.println(nCr3(69,43));
    }

    static int nCr(int n, int r){
        // code here
        int mod = (int)1e9 + 7;
        long a = fact(n) % mod, b = fact(r) % mod, c = fact(n - r) % mod;

        System.out.println(a);
        System.out.println(b);
        long res = (a) / (b * c);

        return (int)res;
    }

    static int nCr2(int n, int r){
        int mod = (int)1e9 + 7;
        long c = fact(r) % mod, a = 1;

        System.out.println(c);

        for (int i = 0; i < r; i++) {
            a *= (n - i) % mod;
        }

        System.out.println(a);

        long res = (a / c) % mod;

        return (int)res;
    }

    static long fact(long num){
        if (num <= 1) return 1;

        return num * fact(num - 1);
    }

    static int nCr3(int n, int r){
        int mod = (int)1e9 + 7;
        if (n < r) return 0;

        // Since 4C1 and 4C3 are the same. These sequences form a palindrome.
        if ((n - r) < r) r = n - r;

        List<List<Long>> cur = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            cur.add(new ArrayList<>());
            for(int j = 0; j <= r && j <= i; j++){
                if (j == 0 || j == i) cur.get(i).add(1L);
                else {
                    cur.get(i).add((cur.get(i - 1).get(j - 1) % mod) + (cur.get(i - 1).get(j) % mod));
                }
            }
        }

        return (int)(cur.get(n).get(r) % mod);
    }
}
