//https://leetcode.com/problems/isomorphic-strings/
package Leetcode;


import java.util.HashMap;

public class Isomorphic_String {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc" , "baba"));
    }
        static boolean isIsomorphic(String s, String t) {
            HashMap<Character , Character> hm = new HashMap<>();
            String ans = "";

            // It is given that of both string is same.
            for (int i = 0 ; i < s.length() ; i++){
                // Append the string in the HashMap if the HashMap is either empty or if the                s.charAt[i] does not exist in HashMap. If it exists, then we just need to                 append the answer, and do nothing.

                // ans.indexOf(t.charAt(i)) == -1 is added because there cannot be more than one s char pointer to a single t char, EG: a and b cannot contain the value a. Both must have different value. We are adding all value in the ans, so we can just check if the value already exist, means we need to avoid the duplicate scenario.
                if (hm.isEmpty() || !hm.containsKey(s.charAt(i)) && ans.indexOf(t.charAt(i)) == -1){
                    hm.put(s.charAt(i) , t.charAt(i));
                }
                ans += hm.get(s.charAt(i));
            }

            return ans.equals(t);
        }
}
