package Leetcode;

import java.util.*;

public class Count_Occurences_of_Anagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(search(pat, txt));
    }

    static int search(String pat, String txt) {
        int n = txt.length(), start = 0, end = 0, k = pat.length(), cnt = 0;
        int[] freq = new int[26];

        for (char ch: pat.toCharArray()){
            freq[ch - 'a']++;
        }

        while (end < n){
            // Don't need to check if its from pat or not, since while running the isPresent function, we are only checking the char which are present in pat.
            freq[txt.charAt(end) - 'a']--;

            if ((end - start) + 1 == k){
                if (isPresent(freq)) cnt++;

                // Increase the start size and incrementing everytime when it reaches the size k
                freq[txt.charAt(start) - 'a']++;
                start++;
            }

            end++;
        }
        return cnt;
    }

    private static boolean isPresent(int[] freq) {
        for (int fq: freq){
            if (fq != 0) return false;
        }

        return true;
    }
}
