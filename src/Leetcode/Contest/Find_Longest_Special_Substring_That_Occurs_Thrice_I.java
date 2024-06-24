package Leetcode.Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.util.Date.parse;

public class Find_Longest_Special_Substring_That_Occurs_Thrice_I {
    public static void main(String[] args) {
        System.out.println(maximumLength("accc"));
    }

    static int maximumLength(String s) {
        int maxi = -1, n = s.length();
        List<String> list = new ArrayList<>();
        int st = 0, e = 0;

        while (e < n) {
            if (list.contains(s.charAt(e) + "") || s.charAt(e) != s.charAt(st)) {
                list.add(st + "");
                st = e;
            }
            else {
                int k = (e - st) + 1;
                String subStr = s.substring(st, e + 1);

                if (isSubExists(k, n, subStr, s)) {
                    maxi = Math.max(k, maxi);
                }

                e++;
            }
        }

        return maxi;
    }

    private static boolean isSubExists(int k, int n, String str, String s) {
        int st = 0, cnt = 0, e = k;

        while (e < n){
            if (cnt == 3) break;
            String sub = s.substring(st, e);

            if (sub.equals(str)){
                cnt++;
            }

            st++;
            e++;
        }

        return cnt == 3;
    }

    static int maximumLength2(String s) {
        int maxi = -1, n = s.length(), i = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        while (i < n) {
            int j = i;

            while (j < n && s.charAt(i) == s.charAt(j)){
                j++;
            }

            int k = j - i;
            String ch = s.charAt(i) + "";
            hm.put(ch + k, hm.getOrDefault(ch + k, 0) + 1);
            if (k > 1) hm.put(ch + (k-1), hm.getOrDefault(ch + (k-1), 0) + 2);
            if (k > 2) hm.put(ch + (k-2), 3);

            i = j;
        }

        for (var entry: hm.entrySet()){
            String k = entry.getKey();
            int v = entry.getValue();

            if (v >= 3){
                maxi = Math.max(maxi, parse(k));
            }
        }

        return maxi;
    }

    private static int parse(String k) {
        int num = k.charAt(1) - '0';

        for (int i = 2; i < k.length(); i++) {
            num = (num * 10) + k.charAt(i) - '0';
        }

        return num;
    }
}
