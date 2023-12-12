package Leetcode;
import java.util.*;

public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length(), l = Math.min(n,m);
        String ans = "";

        for (int i = 0; i < l; i++) {
            ans+=word1.charAt(i);
            ans+=word2.charAt(i);
        }

        if (l == m){
            while (l < n){
                ans += word1.charAt(l);
                l++;
            }
        } else {
            while (l < m){
                ans += word2.charAt(l);
                l++;
            }
        }

        return ans;
    }

    static String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
