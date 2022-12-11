//https://leetcode.com/problems/check-if-the-sentence-is-pangram/
package Leetcode.HashMaps;

import java.util.HashSet;

public class Check_Sentence_Is_Pangram {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            hs.add(sentence.charAt(i));
        }
//        If the size is 26 , then every character is present . Set contains unique values , so duplicates wont be a problem.
        return hs.size() == 26;
    }
}
