package Leetcode;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String str= "9-(5+3)*4/6";
        String ans = postfixConvertor(str);
//        int ans = infix_method_for_brackets(str);
        System.out.println(ans);
    }

    static String postfixConvertor(String str){
        Stack<String> st= new Stack<>();
        Stack<Character> op= new Stack<>();
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57) st.push(ch+"");
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
            String v2 = st.pop();
            String v1 = st.pop();
            StringBuilder sb = new StringBuilder();

            if (op.peek() == '-'){
                sb.append(v1);
                sb.append(v2);
                sb.append('-');
                ans = sb.toString();
            }
            else if (op.peek() == '+'){
                sb.append(v1);
                sb.append(v2);
                sb.append('+');
                ans = sb.toString();
            }
            else if (op.peek() == '*'){
                sb.append(v1);
                sb.append(v2);
                sb.append('*');
                ans = sb.toString();
            }
            else if (op.peek() == '/'){
                sb.append(v1);
                sb.append(v2);
                sb.append('/');
                ans = sb.toString();
            }
            st.push(ans);
            op.pop();
        }
        return ans;
    }

    static void work(Stack<String> st, Stack<Character> op){
        String v2 = st.pop();
        String v1 = st.pop();
        StringBuilder sb = new StringBuilder();

        // The upper element would be the one which appeared later, therefore v2 to it.
        if (op.peek() == '-'){
            sb.append(v1);
            sb.append(v2);
            sb.append('-');
            st.push(sb.toString());
        }
        if (op.peek() == '+'){
            sb.append(v1);
            sb.append(v2);
            sb.append('+');
            st.push(sb.toString());
        }
        if (op.peek() == '*'){
            sb.append(v1);
            sb.append(v2);
            sb.append('*');
            st.push(sb.toString());
        }
        if (op.peek() == '/') {
            sb.append(v1);
            sb.append(v2);
            sb.append('/');
            st.push(sb.toString());
        }
    }
}
