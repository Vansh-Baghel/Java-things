package Leetcode.Contest;

import java.util.*;

public class Find_Beautiful_Indices_in_the_Given_Array_II {
    public static void main(String[] args) {
        System.out.println(beautifulIndices("ggfsg", "gfsg", "g", 4));
    }

    static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();
        int e = 0, n = s.length();
        ArrayList<Integer> f1 = new ArrayList<>(), f2 = new ArrayList<>();
        boolean subSet = false;

        String a1 = a, b1 = b;

        if (a.length() > b.length() && a.contains(b)){
            a1 = b;
            b1 = a;
        }

        if (a1.contains(b1)) subSet = true;

        if (subSet) {
            while (e < n) {
                if (e + a1.length() <= n && s.charAt(e) == a1.charAt(0)) {
                    if (s.substring(e, e + a1.length()).equals(a1)) {
                        f1.add(e);
                        f2.add(e);
                        e += a1.length();
                    }
                } else if (e + b1.length() <= n && s.charAt(e) == b1.charAt(0)) {
                    if (s.substring(e, e + b1.length()).equals(b1)) {
                        f2.add(e);
                        e += b1.length();
                    }
                } else e++;
            }
        } else {
            while (e < n) {
                if (e + a1.length() <= n && s.charAt(e) == a1.charAt(0)) {
                    if (s.substring(e, e + a1.length()).equals(a1)) {
                        f1.add(e);
                    }
                }

                if (e + b1.length() <= n && s.charAt(e) == b1.charAt(0)) {
                    if (s.substring(e, e + b1.length()).equals(b1)) {
                        f2.add(e);
                    }
                }

                e++;
            }
        }

        for (Integer integer : f1) {
            for (Integer value : f2) {
                if (Math.abs(integer - value) <= k) {
                    res.add(integer);
                    break;
                }
            }
        }

        return res;
    }
}
