package Leetcode;

import java.util.HashMap;

public class Word_Pattern {
    public static void main(String[] args) {
//        System.out.println(wordPattern("abba"));
    }

    static boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> hm1 = new HashMap<>();
        HashMap<Character, String> hm2 = new HashMap<>();

        String[] words = s.split(" ");
        int n = words.length;

        if (n != pattern.length()) return false;

        for (int i = 0; i < n; i++) {
            if (!hm1.containsKey(words[i])) hm1.put(words[i], pattern.charAt(i));
            else{
                if (hm1.get(words[i]) != pattern.charAt(i)) return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!hm2.containsKey(pattern.charAt(i))) hm2.put(pattern.charAt(i), words[i]);
            else{
                if (!hm2.get(pattern.charAt(i)).equals(words[i])) return false;
            }
        }

        return true;
    }
    static boolean wordPattern2(String pattern, String s) {
        HashMap<String, Character> hm = new HashMap<>();

        String[] words = s.split(" ");
        int n = words.length;

        if (n != pattern.length()) return false;

        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(words[i])) {
                if (hm.containsValue(pattern.charAt(i))) return false;
                hm.put(words[i], pattern.charAt(i));
            }
            else{
                if (hm.get(words[i]) != pattern.charAt(i)) return false;
            }
        }

        return true;
    }
}
