package Leetcode;

public class Repeated_Substring_Pattern {
    public static void main(String[] args) {
        boolean ans= repeatedSubstringPattern("aba");
        System.out.println(ans);
    }
    static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len/2; i > 0; i--) {
            // Means only if the remainder comes out to be even, then there is a chance of having repeated pattern.
            if (len % i == 0){
                String substr = s.substring(0,i);
                StringBuilder repeated_str = new StringBuilder();

                // len/i will give us the number of times we have to repeat that substring, so we add it into the StringBuilder and check if it matches the original s or not.
                for (int j = 0; j < len/i; j++) {
                    repeated_str.append(substr);
                }
                if (repeated_str.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
