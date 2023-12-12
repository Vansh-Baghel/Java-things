package Leetcode.Contest;

import java.util.HashMap;

public class Isomorphic_String {
    public static boolean areIsomorphic(String S1,String S2)
    {
        // Your code here
        HashMap<Character, Character> hm = new HashMap<>();

        if (S1.length() != S2.length()) return false;

        for (int i = 0; i < S1.length(); i++) {
            if (!hm.containsKey(S1.charAt(i))) hm.put(S1.charAt(i), S2.charAt(i));
            else {
                if (hm.get(S1.charAt(i)) != S2.charAt(i)) return false;
            }
        }

        return true;
    }
}
