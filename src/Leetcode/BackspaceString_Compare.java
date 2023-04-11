package Leetcode;

import java.util.Stack;

public class BackspaceString_Compare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c" , "ad#c"));
    }
    static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char ch : s.toCharArray()){
            if (ch == '#'){
                if (stack1.isEmpty()){
                    continue;
                } else {
                    stack1.pop();
                }
            }   else{
                stack1.push(ch);
            }
        }

        for(char ch : t.toCharArray()){
            if (ch == '#'){
                if (stack2.isEmpty()){
                    continue;
                } else {
                    stack2.pop();
                }
            }   else{
                stack2.push(ch);
            }
        }

        return stack1.equals(stack2);
    }
}
