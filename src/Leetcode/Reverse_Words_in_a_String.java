package Leetcode;

import java.util.*;

public class Reverse_Words_in_a_String {
    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
//        reverseWords(str);
    }

    static String reverseWords(String s) {
//        List<String> ls = new ArrayList<>();
//        String a = "";
//
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) != ' ') a+=s.charAt(i);
//            else {
//                if (a != "") ls.add(a);
//                a = "";
//            }
//        }
//
//        if (a != "") ls.add(a);
//
//        Collections.reverse(ls);
//
//        String ans = "";
//
//        for (int i = 0; i < ls.size(); i++) {
//            ans += ls.get(i);
//            if (i != ls.size() - 1) ans += " ";
//        }
//
//        return ans;

        String[] str = s.trim().split("\\s+");

        String ans = "";
        for (int i = str.length - 1; i >= 0; i--) {
            ans += str[i];
            if (i != 0) ans += " ";
        }
        return ans;
    }
}
