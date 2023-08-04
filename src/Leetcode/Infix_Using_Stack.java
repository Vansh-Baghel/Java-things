package Leetcode;

import java.util.Stack;

public class Infix_Using_Stack {
    public static void main(String[] args) {
        String str= "9-(5+3)*4/6";
        int ans = infix_method(str);
//        int ans = infix_method_for_brackets(str);
        System.out.println(ans);
    }

    static int infix_method(String str){
        Stack<Integer> st= new Stack<>();
        Stack<Character> op= new Stack<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch - 48);
            else if(op.isEmpty()) op.push(ch);
            else if (ch == '-' || ch == '+'){
                if (op.peek() == '-' || op.peek() == '+' || op.peek() == '*' || op.peek() == '/'){
                    work(st,op);
                    op.pop();

                    op.push(ch);
                } else if (op.peek() == '(') op.push(ch);
            }
            if (ch == '*' || ch == '/') {
                if (op.peek() == '*' || op.peek() == '/') {
                    work(st, op);
                    op.pop();

                    op.push(ch);
                }
                else {
                    op.push(ch);
                }
            }
        }
        while (!op.isEmpty()){
        int v2 = st.pop();
        int v1 = st.pop();
        if (op.peek() == '-'){
            ans = (v1-v2);
        }
        else if (op.peek() == '+'){
            ans = (v1+v2);
        }
        else if (op.peek() == '*'){
            ans = (v1*v2);
        }
        else if (op.peek() == '/'){
            ans = (v1/v2);
        }
        st.push(ans);
        op.pop();
    }
        return ans;
    }

    static int infix_method_for_brackets(String str){
        Stack<Integer> st= new Stack<>();
        Stack<Character> op= new Stack<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch - 48);
            else if(op.isEmpty() || ch == '(' || op.peek() == '(') op.push(ch);
            else if(ch == ')'){
                while (!op.isEmpty() && op.peek() != '('){
                    work(st, op);
                    op.pop();
                }
                op.pop();
            }
               else if (ch == '-' || ch == '+'){
                    if (op.peek() == '-' || op.peek() == '+' || op.peek() == '*' || op.peek() == '/'){
                       work(st,op);
                        op.pop();

                        op.push(ch);
                } else if (op.peek() == '(') op.push(ch);
                }
                    if (ch == '*' || ch == '/') {
                        if (op.peek() == '*' || op.peek() == '/') {
                            work(st, op);
                            op.pop();

                            op.push(ch);
                        }
                        else {
                            op.push(ch);
                        }
                    }
            }
        while (!op.isEmpty()){
            int v2 = st.pop();
            int v1 = st.pop();
            if (op.peek() == '-'){
                ans = (v1-v2);
            }
            else if (op.peek() == '+'){
                ans = (v1+v2);
            }
            else if (op.peek() == '*'){
                ans = (v1*v2);
            }
            else if (op.peek() == '/'){
                ans = (v1/v2);
            }
            st.push(ans);
            op.pop();
        }
        return ans;
    }

    static void work(Stack<Integer> st, Stack<Character> op){
        int v2 = st.pop();
        int v1 = st.pop();

        // The upper element would be the one which appeared later, therefore v2 to it.
        if (op.peek() == '-'){
            st.push(v1-v2);
        }
        if (op.peek() == '+'){
            st.push(v1+v2);
        }
        if (op.peek() == '*'){
            st.push(v1*v2);
        }
        if (op.peek() == '/') {
            st.push(v1 / v2);
        }
    }
}


