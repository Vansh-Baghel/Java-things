package Leetcode;

public class Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram" , "nagaram"));
    }
    static boolean isAnagram(String s, String t) {
//         if the length of both the strings is not equal then its not anagram.
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0 ; i < s.length() ; i++ ){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count)
            if (i != 0){
                return false;
            }
        return true;
    }
}
