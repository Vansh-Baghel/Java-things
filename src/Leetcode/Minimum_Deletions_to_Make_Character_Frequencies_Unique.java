package Leetcode;

import java.util.HashSet;

public class Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    public int minDeletions(String s) {
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            arr[charIndex]++;
        }

        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && hs.add(arr[i]) == false){
                arr[i]--;
                count++;
            }
        }
        return count;
    }


}
