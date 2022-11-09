//https://leetcode.com/problems/longest-substring-without-repeating-characters/
package Leetcode.HashMaps;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0 , right = 0 , length = 0 ;
        while (right < s.length()) {
            if (hm.containsKey(s.charAt(right))) {
//                Here hm.get(s.charAt(right) + 1 will return the index of the character at right which is already present in the hashmap . Note that it will not return the index where right is at. If the index of left is greater than index of char at right in hashmap , then dont need to move the left pointer.
//                EG:- hashMap ((a,0) , (b,1) , (c,2)) here if charAt(right) = a , left = a then hm.get(s.charAt(right) + 1 = 1 and left = 0, therefore left will move to 1.
                left = Math.max(hm.get(s.charAt(right)) + 1, left);
            }
//            This will everytime update the existing value and also increment if the value is not present.
            hm.put(s.charAt(right), right);
//            +1 is needed because if left = 0 , right = 1 that means length must be 2 but if we do r - l then its 1. Therefore return the max length.
            length = Math.max(length, right - left + 1);
            right++;
        }
    return length;
    }
}
