package Leetcode.Contest;

import java.util.*;

public class Count_Beautiful_Substrings_I {
    public static void main(String[] args) {
        System.out.println(beautifulSubstrings("ihroyeeb", 5));
    }

    static int beautifulSubstrings(String s, int k) {
        int n = s.length(), res = 0, start = 0, e = 0;
        int[] v = new int[n], c = new int[n];

        while (e < n){
            if (isVowel(s.charAt(e))) {
                v[e]++;
            } else c[e]++;

            if (v[e] == c[e] && v[e] % k == 0) res++;
        }
        return res;
    }

    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
