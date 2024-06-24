package Leetcode;

import java.util.HashMap;

public class Largest_Substring_Between_Two_Equal_Characters {
    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }
    static int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        System.out.println(s.length());
        int maxi = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (hm.containsKey(ch)){
                maxi = Math.max((i - hm.get(ch)) - 1, maxi);
            } else {
                hm.put(ch, i);
            }
        }

        return maxi;
    }
}
