package Leetcode;

import java.util.*;

public class Search_Pattern_KMP_Algorithm {
    public static void main(String[] args) {
        char a = 'a' + 1;
        char b = 'b';
        System.out.println(a==b);

        System.out.println(search("geek", "geeksforgeeks"));
    }

    static ArrayList<Integer> search(String pat, String txt){
        int n = pat.length(), m = txt.length();
        int[] lps = new int[n];
        ArrayList<Integer> res = new ArrayList<>();

        formLps(pat, lps);

        int i = 0, j = 0;

        while (i < m){
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;

                // If equal hai dono indices, and length of j becomes same as that of the pattern, then we have found one of the patterns.
                if (j == n) {
                    res.add(i - j + 1);
                    j = lps[j - 1];
                }
            }
            else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        if (res.isEmpty()) res.add(-1);

        return res;
    }

    static void formLps(String pat, int[] lps){
        int n = pat.length(), prevLps = 0, i = 1;

        while (i < n){
            if (pat.charAt(i) == pat.charAt(prevLps)){
                prevLps++;
                lps[i] = prevLps;
                i++;
            } else {
                if (prevLps == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLps = lps[prevLps - 1];
                }
            }
        }
    }









    static ArrayList<Integer> search2(String pat, String txt){
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length(), m = pat.length();
        int[] lps = new int[m];
        getLps(lps, pat, m);

        int i = 0, j = 0;
        while (i < n){
            if (txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;

                if (j == m) {
                    // + 1 because its 1 based indexing
                    res.add((i - m) + 1);
                    j = lps[j - 1];
                }
            } else{
                // Equal nhi h toh previous num k index par chale jaao.
                if (j == 0) i++;
                else j = lps[j - 1];
            }
        }

        return res;
    }

    static void getLps(int[] lps, String pat, int m) {
        int i = 1, len = 0;
        while (i < m){
            if (pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0){
                    lps[i] = 0;
                    i++;
                } else len = lps[len - 1];
            }
        }
    }
}
