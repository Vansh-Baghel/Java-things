package Leetcode;

public class Lexicographically_Smallest_String_After_Substring_Operation {
    public static void main(String[] args) {
        System.out.println(smallestString("cbabc"));
    }

    static String smallestString(String s) {
        int n = s.length(), e = 0;
        StringBuilder str = new StringBuilder();

        while (e < n - 1 && s.charAt(e) == 'a') {
            str.append(s.charAt(e));
            e++;
        }

        if (e == n - 1 && s.charAt(e) == 'a') {
            str.append('z');
            e++;
        }

        while (e < n && s.charAt(e) != 'a'){
            str.append((char)(s.charAt(e) - 1));
            e++;
        }

        str.append(s.substring(e));

        return str.toString();
    }

    public String smallestString2(String s) {
        int n = s.length(), start = 0;

        char[] arr=s.toCharArray();

        while (start < n && arr[start] == 'a') {
            start++;
        }
        if (start == n) arr[n - 1] = 'z';

        while (start < n && arr[start] != 'a'){
            arr[start++]--;
        }

        return new String(arr);
    }
}
