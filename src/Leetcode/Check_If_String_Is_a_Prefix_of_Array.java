package Leetcode;
import java.util.*;

public class Check_If_String_Is_a_Prefix_of_Array {
    public static void main(String[] args) {
        String[] arr = {"i","love","leetcode","apples"};
        System.out.println(isPrefixString("iloveleetcode" , arr));
    }

    static boolean isPrefixString(String s, String[] words) {
        String ans = "";

        for(String word: words){
            // Appending the string into the string.
            ans += word;

            if (s.equals(ans)) return true;

            // If the index doesn't matches, then just return false.
            if (s.indexOf(ans) == -1) return false;
        }

        return false;
    }
}
