package Leetcode;

import java.util.*;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    static String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0, n = s.length(), counter = t.length(), size=Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }

        for (int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            if (!hm.containsKey(cur)) hm.put(cur, -1);
            else{
                int curCnt = hm.get(cur);
                if (curCnt > 0) counter--;
                hm.put(cur, hm.getOrDefault(cur, 0) - 1);
            }

            while (counter == 0){
                char st = s.charAt(start);
                hm.put(st, hm.getOrDefault(st, 0) + 1);

                int stCnt = hm.get(st);
                if (stCnt > 0) {
                    if (size > (end - start) + 1){
                        size = (end - start) + 1;
                        res = s.substring(start, end + 1);
                    }
                    counter++;
                    start++;
                } else start++;
            }
        }

        return res;
    }

    static String minWindow2(String s, String t) {
        String res = "";
        HashMap<Character, Integer> hm = new HashMap<>();

        int k = t.length(), n = s.length(), start = 0, resSize = Integer.MAX_VALUE;

        for (char ch: t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int e = 0; e < n; e++){
            char ch = s.charAt(e);
            hm.put(ch, hm.getOrDefault(ch, 0) - 1);

            if (hm.get(ch) >= 0) {
                k--;
            }

            while (k == 0){
                char startCh = s.charAt(start);
                int curSize = e - start + 1;

                hm.put(startCh, hm.get(startCh) + 1);

                if (hm.get(startCh) > 0){
                    k++;
                    if (resSize > curSize) {
                        resSize = curSize;
                        res = s.substring(start, e + 1);
                    }
                }

                start++;
            }
        }

        return res;
    }
}
