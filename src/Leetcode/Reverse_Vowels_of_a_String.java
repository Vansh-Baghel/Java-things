package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Reverse_Vowels_of_a_String {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    static String reverseVowels(String s) {
//        int n = s.length();
//        List<Character> ch = new ArrayList<>();
//        List<Integer> idx = new ArrayList<>();
//        char[] arr = s.toCharArray();
//
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
//                ch.add(s.charAt(i));
//                idx.add(i);
//            }
//        }
//
//        int m = idx.size();
//        for (int i = 0; i < m; i++) {
//            arr[idx.get(i)]= ch.get(m - i - 1);
//        }
//        String ans = new String(arr);
//        return ans;

        int n = s.length(), start = 0, end = n - 1;
        String vowels = "aeiouAEIOU";
        char[] word = s.toCharArray();

        while (start < end) {
            while (start < end && vowels.indexOf(word[start]) == -1){
                start++;
            }
            while (start < end && vowels.indexOf(word[end]) == -1){
                end--;
            }

            char temp = s.charAt(start);
            word[start] = s.charAt(end);
            word[end] = temp;

            start++;
            end--;
        }

        String ans = new String(word);
        return ans;
    }
}
