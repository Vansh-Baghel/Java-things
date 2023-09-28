package Leetcode.Contest;

import java.util.Stack;

public class Empty_the_String {
    public static void main(String[] args) {
        System.out.println(makeStringEmpty2("geek"));
    }

    // Brute force
    static int makeStringEmpty(String s) {
        int n = s.length();
        int temp = s.length();
        int ans = 0;
        String delStr = "geek";
        int m = delStr.length();

        while (n >= m){
            temp=n;
            for (int idx = 0; idx <= n-m; idx++) {
                String str = s.substring(idx, idx+m);

                if (str.equals(delStr)) {
                    String a = s.substring(0, idx);
                    String b = s.substring(idx+m);
                    ans++;
                    s=a.concat(b);
                    n=s.length();
                }
            }
            if (temp == n) return -1;
        }

        if (s.length() != 0) return -1;
        return ans;
    }

    static int makeStringEmpty2(String s) {
        Stack<Character> st = new Stack<>();
        int idx = 0;
        int ans = 0;
        int n = s.length();

        while (idx < n){
            while (s.charAt(idx) != 'k'){
                st.add(s.charAt(idx));
                idx++;
            }

            if (idx > n-1 || s.charAt(idx) != 'k'){
               return -1;
            }
            if (st.isEmpty() || st.pop() != 'e'){
                return -1;
            }
            if (st.isEmpty() || st.pop() != 'e'){
                return -1;
            }
            if (st.isEmpty() || st.pop() != 'g'){
                return -1;
            }

            ans++;
            idx++;
        }

        if (!st.isEmpty()) return -1;
        return ans;
    }
}
