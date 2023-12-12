package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        System.out.println(areIsomorphic("wfca", "yssy"));
    }

    static boolean areIsomorphic(String str1,String str2){
        // Your code here
        if (str1.length() != str2.length()) return false;

        StringBuilder newS2 = new StringBuilder();
        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (!hm.containsKey(str1.charAt(i)) && newS2.toString().indexOf(str2.charAt(i)) == -1){
                hm.put(str1.charAt(i), str2.charAt(i));
            }
            newS2.append(hm.get(str1.charAt(i)));
        }

        System.out.println(newS2);

        return newS2.toString().equals(str2);
    }

    public static boolean areIsomorphic2(String str1,String str2) {
        // Your code here
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            char s1 = str1.charAt(i), s2 = str2.charAt(i);
            if (hm.containsKey(s1)) {
                if (hm.get(s1) != s2) return false;
            } else if (hs.contains(s2)) return false;
            else {
                hm.put(s1, s2);
                hs.add(s2);
            }
        }
            return true;
        }
    }

