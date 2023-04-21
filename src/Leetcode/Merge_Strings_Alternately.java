package Leetcode;
import java.util.*;

public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int k = 0;
        Character[] ans = new Character[word1.length() + word2.length()];
        while (word1.length() != i && word2.length() != j){
            ans[k++] = word1.charAt(i++);
            ans[k++] = word2.charAt(j++);
        }
        while (word1.length() != i){
            ans[k++] = word1.charAt(i++);
        }
        while (word2.length() != j){
            ans[k++] = word2.charAt(j++);
        }
        return Arrays.toString(ans).replaceAll("\\[|\\]|,|\\s", "");
    }
}
