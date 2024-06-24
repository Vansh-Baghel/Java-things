package Leetcode;

import java.util.*;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<>();

        // Add strings to the ArrayList
        listOfWords.add("aa");
        listOfWords.add("bb");

        System.out.println(maxLength(listOfWords));
    }

    static int maxLength(List<String> arr) {
        int n = arr.size();
        return solve(n - 1, "", arr);
    }

    private static int solve(int idx, String str, List<String> arr) {
        if (idx < 0) {
            return str.length();
        }

        int pick = 0, notPick = 0;

        if (!isRepeated(arr.get(idx), str)){
            pick = solve(idx - 1, str + arr.get(idx), arr);
        }

        notPick = solve(idx - 1, str, arr);

        return Math.max(pick, notPick);
    }

    private static boolean isRepeated(String cur, String str) {
        int[] freq = new int[26];

        // If cur waala hee repeated nikla
        for (char ch: cur.toCharArray()){
            if (freq[ch - 'a'] > 0) return true;
            freq[ch - 'a']++;
        }

        for (char ch: str.toCharArray()){
            if (freq[ch - 'a'] > 0) return true;
        }

        return false;
    }
}
