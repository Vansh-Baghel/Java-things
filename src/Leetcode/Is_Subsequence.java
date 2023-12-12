package Leetcode;

public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length(), a = 0, b = 0;

        if (n > m) return false;

        while (a < n && b < m){
            if (s.charAt(a) == t.charAt(b)){
                a++;
            }
            b++;
        }

        if (n == a) return true;
        return false;
    }
}
