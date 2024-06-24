package Leetcode;

import java.util.*;

public class Text_Justification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words, 16));
    }

    static List<String> fullJustify(String[] words, int maxWidth) {
        int extraSpaces = 0, eachSpaceLength = 0, i = 0, j = 0, lettersLen = 0, n = words.length;
        List<String> res = new ArrayList<>();

         while (i < n){
             lettersLen += words[j].length();
             j++;
             int spaces = 0;

             while (j < n && words[j].length() + 1 + lettersLen + spaces <= maxWidth){
                 lettersLen += words[j].length();
                 j++;
                 spaces++;
             }

             int remainingSpaces = maxWidth - lettersLen;

             eachSpaceLength = spaces == 0 ? 0 : remainingSpaces / spaces;
             extraSpaces = spaces == 0 ? 0 : remainingSpaces % spaces;

             if (j == n) {
                 eachSpaceLength = 1;
                 extraSpaces = 0;
             }

             res.add(findLine(i, j, eachSpaceLength, extraSpaces, words, maxWidth));

             i = j;
             lettersLen = 0;
         }

         return res;
    }

    private static String findLine(int i, int j, int eachSpaceLength, int extraSpaces, String[] words, int maxWidth) {
        StringBuilder line = new StringBuilder();

        for (int k = i; k < j; k++) {
            line.append(words[k]);

            // No space after the last lines
            if (k == j - 1) {
                continue;
            }

            for (int l = 0; l < eachSpaceLength; l++) {
                line.append(' ');
            }

            if (extraSpaces > 0){
                line.append(' ');
                extraSpaces--;
            }
        }

        while (line.length() < maxWidth) line.append(' ');

        return line.toString();
    }
}
