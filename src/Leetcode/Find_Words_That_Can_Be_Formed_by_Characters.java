package Leetcode;

import java.util.*;

public class Find_Words_That_Can_Be_Formed_by_Characters {
    static int countCharacters(String[] words, String chars) {
        int cnt = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char ch : chars.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (String word : words) {
            if (contains(word, hm)) {
                cnt += word.length();
            }
        }

        return cnt;
    }

    private static boolean contains(String word, HashMap<Character, Integer> hm) {
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char ch : word.toCharArray()) {
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hm2.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (!hm.containsKey(ch) || hm.get(ch) < count) return false;
        }
        return true;
    }
}

