package Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Checking if the stack is empty, else it will give error on pop.
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

// Converting the array of characters of stack into string.
        StringBuilder stackArr = new StringBuilder();
        for(char c: stack){
            stackArr.append(c);
        }
        return stackArr.toString();
    }
}
