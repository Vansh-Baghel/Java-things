package Leetcode.Contest;

public class Count_the_Number_of_Special_Characters_II {
    public int numberOfSpecialChars(String word) {
        int[] f1 = new int[26], f2 = new int[26];
        int res = 0;

        for (char ch: word.toCharArray()){
            if (ch < 'a') f2[ch - 'A']++;
            else if (f2[ch - 'a'] > 0) f1[ch - 'a']=-1;
            else if (f1[ch-'a'] != -1) f1[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (f1[i] > 0 && f2[i] > 0) res++;
        }

        return res;
    }
}
