package Leetcode;

public class Reverse_Prefix_of_Word {
    static String reversePrefix(String word, char ch) {
        StringBuilder res = new StringBuilder("");
        int n = word.length();

        for (int i = 0; i < n; i++){
            if (word.charAt(i) == ch) {
                res.append(word.substring(0, i + 1)).reverse();
                res.append(word.substring(i + 1));
                return res.toString();
            }
        }

        return word;
    }
}
