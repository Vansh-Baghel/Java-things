package Leetcode.Contest;

import java.util.*;

public class Find_Beautiful_Indices_in_the_Given_Array_I {
    public static void main(String[] args) {
        String s = "isawsquirrelnearmyhouseohmy", a = "my", b = "squirrel";
        int k = 15;
        System.out.println(beautifulIndices(s,a,b,k));
    }

    static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();
        int e = 0, n = s.length();
        ArrayList<Integer> f1 = new ArrayList<>(), f2 = new ArrayList<>();

        while (e < n){
            if (e + a.length() <= n && s.charAt(e) == a.charAt(0)){
                if (s.substring(e, e + a.length()).equals(a)){
                    f1.add(e);
                }
            }

            if (e + b.length() <= n && s.charAt(e) == b.charAt(0)){
                if (s.substring(e, e + b.length()).equals(b)){
                    f2.add(e);
                }
            }

            e++;
        }

        Collections.sort(f1);
        Collections.sort(f2);

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
