package Leetcode;

import java.util.Arrays;

public class Valid_Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        // Removing all spaces, and chars which are not alphanumeric.
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Convert the cleaned string to an array of words.
        String[] words = cleanedString.split("");

        // Join with space using String.join
        String result = String.join("", words);

        return checkIfPalindrome(result);
    }

    private static boolean checkIfPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }

    static boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char firstCh = s.charAt(start);
            char lastCh = s.charAt(end);

            if (!Character.isLetterOrDigit(firstCh)) start++;
            else if (!Character.isLetterOrDigit(lastCh)) end--;
            else {
                if (Character.toLowerCase(firstCh) != Character.toLowerCase(lastCh)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
