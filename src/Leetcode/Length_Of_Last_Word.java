//https://leetcode.com/problems/length-of-last-word/
package Leetcode;

public class Length_Of_Last_Word {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
    }

    static int lengthOfLastWord(String s) {
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--){
            while (s.charAt(i) == ' '){
                i--;
            }
            while (s.charAt(i) != ' ') {
                cnt++;
                i--;
            }
            break;
        }

        return cnt;
    }
}
