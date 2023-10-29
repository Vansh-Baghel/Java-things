package Leetcode;

import java.util.HashSet;

public class Count_number_of_substrings {
    public static void main(String[] args) {
        System.out.println(substrCount("aba", 2));
    }

    static long substrCount (String S, int K) {
        return atmost (S, K) - atmost(S, K-1);
    }

    private static long atmost(String S, int K) {
        int[] arr = new int[26];
        int n = S.length();

        int cnt = 0, left = 0, ans = 0;

        for (int right = 0; right < n; right++) {
            arr[S.charAt(right)-'a']++;
            if (arr[S.charAt(right) - 'a'] == 1) cnt++;

            while (cnt > K){
                arr[S.charAt(left)-'a']--;
                if (arr[S.charAt(left) - 'a'] == 0) cnt--;
                left++;
            }

            ans = ans + (right-left+1);
        }
        return ans;
    }
}
