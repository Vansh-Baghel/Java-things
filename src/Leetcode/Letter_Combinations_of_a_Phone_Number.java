package Leetcode;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static HashMap<Character, String> hm = new HashMap<>();

    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int n = digits.length();

        if (digits.length() == 0) return ans;

        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        solve(0, n, ans, digits, str);
        return ans;
    }

    static void solve(int idx, int n, List<String> ans, String digits, StringBuilder temp) {
        if (idx >= n) {
            ans.add(temp.toString());
            return;
        }

        String str = hm.get(digits.charAt(idx));

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            solve(idx+1,n, ans, digits, temp);
            temp.deleteCharAt(idx);
        }
    }
}
