//https://leetcode.com/problems/generate-parentheses/
package Leetcode.LinkedList;
import java.util.*;

public class Generate_Parenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack( "", 0 , 0 , ans , n);
        return ans;
    }

    static void backtrack(String str , int open, int close, List<String> ans , int maxLength) {
        // If both open and close is of length n , then return.
        if (open == maxLength && close == maxLength){
            ans.add(str);
            return;
        }

// Total open and close brackets would be n which is given.

        if (open <= maxLength || close <= maxLength) {
            // Print close bracket only if the count of open is greater than the close ones.
            // Else it will form brackets which are not closed paranthesis .
            if (close < open) {
                backtrack(str + ")", open, close + 1, ans, maxLength);
            }
            // Print open if its smaller than n .
            if (open < maxLength) {
                backtrack(str + "(", open + 1, close, ans, maxLength);
            }
        }
    }
}
