package Leetcode;

public class Implement_Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("-123"));
    }

    static int atoi(String s) {
        int res = 0;
        boolean negFlag = false;

        if (s.charAt(0) == '-') {
            negFlag = true;
        }
        else res = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9'){
                res *= 10;
                res += ch - '0';
            } else return -1;
        }

        return negFlag ? res * -1 : res;
    }
}
