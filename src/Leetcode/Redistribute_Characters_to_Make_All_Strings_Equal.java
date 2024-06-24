package Leetcode;

public class Redistribute_Characters_to_Make_All_Strings_Equal {
    static boolean makeEqual(String[] words) {
        int[] alpha = new int[26];
        int n = words.length;

        if (n == 1) return true;

        for (String word: words){
            for (char ch: word.toCharArray()){
                alpha[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0 && alpha[i] % n == 0) return false;
        }

        return true;
    }
}
