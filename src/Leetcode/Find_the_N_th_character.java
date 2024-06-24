package Leetcode;

public class Find_the_N_th_character {
    public char nthCharacter(String s, int r, int n){
        //code here
        String str = "";
        for (char ch: s.toCharArray()){
            str += solve(ch + "", r);
            if (str.length() - 1 >= n) return str.charAt(n);
        }

        return str.charAt(n);
    }

    public String solve(String str, int r){
        if (r == 0) return str;

        String temp = "";

        for (char ch: str.toCharArray()){
            if (ch == '0') temp += "01";
            else temp += "10";
        }

        return solve (temp, r-1);
    }
}
