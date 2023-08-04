package Leetcode;

import java.util.Stack;

public class Postfix_Evaluation {
    public static void main(String[] args) {
        String str= "953+4*6/-";
        int ans = postfix_evalation(str);
//        int ans = infix_method_for_brackets(str);
        System.out.println(ans);
    }

    static int postfix_evalation(String str){
        Stack<Integer> st= new Stack<>();
        int ans = 0;

        // We just need 1 stack and add all the numbers in the beginning and once the operators come, pop 2 nums and evaluate them.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch - 48);
            else{
                work(st, ch);
            }
        }
        return st.peek();
    }

    static void work(Stack<Integer> st, char ch){
        int v2 = st.pop();
        int v1 = st.pop();

        // The upper element would be the one which appeared later, therefore v2 to it.
        if (ch == '-'){
            st.push(v1-v2);
        }
        if (ch == '+'){
            st.push(v1+v2);
        }
        if (ch == '*'){
            st.push(v1*v2);
        }
        if (ch == '/') {
            st.push(v1 / v2);
        }
    }
}
