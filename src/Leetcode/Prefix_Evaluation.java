package Leetcode;

import java.util.Stack;

public class Prefix_Evaluation {
    public static void main(String[] args) {
        String str= "-9/*+5346";
        int ans = prefix_evalation(str);
        System.out.println(ans);
    }

    static int prefix_evalation(String str){
        Stack<Integer> st= new Stack<>();
        int ans = 0;

        // We just need 1 stack and add all the numbers in the beginning and once the operators come, pop 2 nums and evaluate them.
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch - 48);
            else{
                work(st, ch);
            }
        }
        return st.peek();
    }

    static void work(Stack<Integer> st, char ch){
        // NOTE: This is inverse, first pop will give v1.
        int v1 = st.pop();
        int v2 = st.pop();

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
