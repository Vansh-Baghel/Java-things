package Leetcode;

import java.util.HashMap;

public class Roman_Number_to_Integer {
    public static void main(String[] args) {
        System.out.println(romanToDecimal("XIX"));
    }

    static int romanToDecimal(String str) {
        int n = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int ans = hm.get(str.charAt(n - 1));

        for (int i = n-2; i >= 0; i--) {
            if (hm.get(str.charAt(i)) < hm.get(str.charAt(i+1))){
                ans -= hm.get(str.charAt(i));
            } else {
                ans += hm.get(str.charAt(i));
            }
        }

        return ans;
    }
}
