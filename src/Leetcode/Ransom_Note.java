package Leetcode;

public class Ransom_Note {
    static boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        int n = ransomNote.length(), m = magazine.length();

        for (int i = 0; i < n; i++) {
            letters[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            letters[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0) return false;
        }

        return true;
    }

    static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}
