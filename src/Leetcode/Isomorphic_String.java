//https://leetcode.com/problems/isomorphic-strings/
package Leetcode;


import java.util.HashMap;

public class Isomorphic_String {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> hm = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) != t.charAt(i) || hm.containsValue(t.charAt(i))){
                    return false;
                }
                else hm.put(s.charAt(i) , t.charAt(i));
            }
            return true;
        }
}
