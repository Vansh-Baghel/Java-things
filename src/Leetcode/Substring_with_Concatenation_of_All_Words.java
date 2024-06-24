package Leetcode;

import java.util.*;

public class Substring_with_Concatenation_of_All_Words {
    static List<Integer> findSubstring(String s, String[] words) {
        int wordArrSize = words.length, wordSize = words[0].length(), n = s.length(), k = wordSize * wordArrSize;
        HashMap<String, Integer> hm1 = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        for (String word: words){
            hm1.put(word, hm1.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= n - k; i++) {
            // Full k size ka substring leliya.
            String substr = s.substring(i, i + k);
            HashMap<String, Integer> hm2 = new HashMap<>();

            for (int j = 0; j < k - wordSize; j+=wordSize) {
                // Taking substrings of wordSize.
                String cur = substr.substring(j, j + wordSize);
                hm2.put(cur, hm2.getOrDefault(cur, 0) + 1);
            }
            if (hm1.equals(hm2)) res.add(i);
        }

        return res;
    }

    static List<Integer> findSubstring2(String s, String[] words) {
        int wordArrSize = words.length, start = 0, end = 0, wordSize = words[0].length(), n = s.length(), k = wordSize * wordArrSize;

        List<Integer> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        while (end <= n) {
            String substr = s.substring(start, end);
            str.append(substr);

            if (str.length() == k){
                if (isValid(str.toString(), words)) res.add(start);
                str.delete(0, wordSize+1);
                start += wordSize;
            }

            end+=wordSize;
        }

        return res;
    }

    private static boolean isValid(String str, String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
        int wordSize = words[0].length();

        for (String word: words) hm.put(word, hm.getOrDefault(word, 0) + 1);

        for (int i = 0; i < str.length(); i+=wordSize) {
            String substr = str.substring(i, i+wordSize);

            if (!hm.containsKey(substr) || hm.get(substr) <= 0) return false;
            hm.put(substr, hm.get(substr) - 1);
        }

        return true;
    }
}
