package Recursion.Arrays;

import java.util.Arrays;

public class ReversingArray {
    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
    }

    static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            if (i == s.length / 2){
                return;
            }
            swap(s , i , s.length - i - 1);
        }
            System.out.print(Arrays.toString(s));
    }

    private static void swap(char[] s , int startC, int fromEndC) {
        char temp = s[startC];
        s[startC] =  s[fromEndC];
        s[fromEndC] = temp;
    }
}
