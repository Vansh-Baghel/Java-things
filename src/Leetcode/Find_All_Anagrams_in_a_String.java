package Leetcode;

import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        int start = 0, end = 0, n = s.length(), k = p.length();

        for (char ch: p.toCharArray()){
            freq[ch - 'a']++;
        }

        while (end < n){
            freq[s.charAt(end) - 'a']--;

            if ((end - start) + 1 == k){
                if (isAnagram(freq)) ans.add(start);

                freq[s.charAt(start) - 'a']++;
                start++;
            }

            end++;
        }

        return ans;
    }

    private static boolean isAnagram(int[] freq) {
        for (int i: freq) {
            if (i != 0) return false;
        }
        return true;
    }
}
