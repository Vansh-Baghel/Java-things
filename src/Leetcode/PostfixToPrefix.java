package Leetcode;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String str= "953+4*6/-";
        String ans = preToPost(str);
//        int ans = infix_method_for_brackets(str);
        System.out.println(ans);
    }

    static String preToPost(String str) {
        Stack<String> st= new Stack<>();
        int ans = 0;

        // We just need 1 stack and add all the numbers in the beginning and once the operators come, pop 2 nums and evaluate them.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch + "");
            else{
                work(st, ch);
            }
        }
        return st.peek();
    }

    static void work(Stack<String> st, char ch){
        // NOTE: This is inverse, first pop will give v1.
        String v1 = st.pop();
        String v2 = st.pop();

        // The upper element would be the one which appeared later, therefore v2 to it.
        if (ch == '-'){
            st.push("-" + v1 + v2 );
        }
        if (ch == '+'){
            st.push("+" + v1+v2);
        }
        if (ch == '*'){
            st.push("*" + v1+v2);
        }
        if (ch == '/') {
            st.push("/" + v1 + v2);
        }
    }
}
