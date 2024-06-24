package Leetcode;

import java.util.*;

public class Power_Set {
    public static void main(String[] args) {
        System.out.println(AllPossibleStrings("abc"));
    }

    public static List<String> AllPossibleStrings(String s) {
        List<String> res = new ArrayList<>();
        solve(0, s.length(), "", s, res);

        Collections.sort(res);
        return res;
    }

    public static void solve (int idx, int n, String str, String s, List<String> res){
        if (idx == n) {
            if (!str.equals("")) res.add(str);
            return;
        }

        solve(idx + 1, n, str+s.charAt(idx), s, res);
        solve(idx + 1, n, str, s, res);
    }
}
