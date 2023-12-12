package Leetcode;

public class Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
    static int maxVowels(String s, int k) {
        int n = s.length(), strt=0, cnt=0, maxi=0;
        String vowels = "aeiou";

        for (int e = 0; e < n; e++) {
            char endChar = s.charAt(e);
            char strtChar = s.charAt(strt);
            if (vowels.indexOf(endChar) != -1) cnt++;
            if (e >= k) {
                if (vowels.indexOf(strtChar) != -1) cnt--;
                strt++;
            }
            maxi = Math.max(maxi, cnt);
            if (maxi == k) break;
        }

        return maxi;
    }
}
