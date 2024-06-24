package Leetcode;

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        System.out.println(removeKdigits2("725083", 5));
    }

    static String removeKdigits(String S, int K) {
        int e = 0, n = S.length();
        StringBuilder res = new StringBuilder(S);

        while (K != 0){
            if (e + 1 < res.length() && res.charAt(e) - '0' > res.charAt(e+1) - '0'){
                res.deleteCharAt(e);
                if (e != 0) e--;
                e--;
                K--;
            }

            if (e == res.length() - 1 && K != 0) {
                res.delete(res.length() - K, res.length());
                break;
            }

            e++;
        }

        while (res.length() > 0) {
            if (res.charAt(0) == '0') res.deleteCharAt(0);
            else break;
        }

        if (res.length() == 0) res.append('0');

        return res.toString();
    }

    static String removeKdigits2(String S, int K) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char ch: S.toCharArray()){
            if (K == 0) break;
            if (!st.isEmpty() && ch < st.peek()){
                while (!st.isEmpty() && st.peek() > ch){
                    st.pop();
                    K--;
                }
            }

            st.add(ch);
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        while (!res.isEmpty() && K != 0) {
            while (res.charAt(0) == '0') res.deleteCharAt(0);
            res.deleteCharAt(0);
            K--;
        }

        return res.toString();
    }
}
