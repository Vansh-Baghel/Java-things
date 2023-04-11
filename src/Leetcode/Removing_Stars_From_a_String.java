package Leetcode;

import java.util.Stack;

public class Removing_Stars_From_a_String {
        public String removeStars(String s) {
            Stack<Character> stack = new Stack<>();

            for(char ch : s.toCharArray()){
                if (ch == '*'){
                    if (stack.isEmpty()){
                        continue;
                    } else {
                        stack.pop();
                    }
                }   else{
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
