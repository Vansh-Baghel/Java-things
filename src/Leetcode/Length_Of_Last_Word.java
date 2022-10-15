//https://leetcode.com/problems/length-of-last-word/
package Leetcode;

public class Length_Of_Last_Word {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
    }

    static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                count++;
            }
//            It will check this condition only if s contains space . Once we start counting then any space indicates that the word has finished. Actually s.charAt(i) == ' ' condition is not necessary because only if there is a space in the string this condition will be applied, and plus with count > 0 condition is complete to print the last word ka index.
            else if (count > 0 && s.charAt(i) == ' '){
                return count;
            }
        }
        return count;
    }
}
