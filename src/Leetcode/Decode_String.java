package Leetcode;

import java.util.Stack;

public class Decode_String {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
    static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char ch: s.toCharArray()){
            if(ch != ']') st.add(ch+"");
            else{
                StringBuilder tmpStr = new StringBuilder();
                int num = 0;

                while (!st.peek().equals("[")){
                    String top = st.pop();
                    tmpStr.append(top);
                }

                // Removing "["
                st.pop();
                StringBuilder numStr = new StringBuilder();

                while(!st.isEmpty() && isNumeric(st.peek())){
                    numStr.append(st.pop());
                }

                num += Integer.parseInt(numStr.reverse().toString());

                String str = tmpStr.toString();
                for (int i = 0; i < num-1; i++) {
                    tmpStr.append(str);
                }

                st.add(tmpStr.toString());
            }
        }

        while (!st.isEmpty()) ans.append(st.pop());

        return ans.reverse().toString();
    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
