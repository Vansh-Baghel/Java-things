package Leetcode.Contest;

import java.util.HashSet;
import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') st.add(i);

            else if (s.charAt(i) == ')') {
                if (st.isEmpty()) hs.add(i);
                else st.pop();
            }
        }

        // HashSet mai O(1) mai hojayega
        while (!st.isEmpty()) hs.add(st.pop());

        for (int i = 0; i < s.length(); i++){
            if (!hs.contains(i)) res.append(s.charAt(i));
        }

        return res.toString();
    }
}
