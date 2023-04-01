//https://leetcode.com/problems/determine-if-two-strings-are-close/description/
package Leetcode;
import java.util.*;

public class Determine_if_Two_StringsAreClose {
        public boolean closeStrings(String word1, String word2) {
                HashSet<Character> hs = new HashSet<>();
                int[] arr1 = new int[26];
                int[] arr2 = new int[26];
                int count = 0;

                // Creating an array and incrementing the count of the index of alphabet
                for(char ch: word1.toCharArray()){
                    arr1[ch - 'a']++;
                    hs.add(ch);
                }

                // Creating an array and decrementing the count of the index of alphabet

                for(char ch: word2.toCharArray()){
                    arr2[ch - 'a']++;
                    hs.remove(ch);
                }

                Arrays.sort(arr1); Arrays.sort(arr2);
                return Arrays.toString(arr1).equals(Arrays.toString(arr2)) && hs.size()==0;
            }
}
