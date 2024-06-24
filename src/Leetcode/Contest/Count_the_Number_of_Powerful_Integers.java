package Leetcode.Contest;

import java.util.*;

public class Count_the_Number_of_Powerful_Integers {
    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(1,6000,4,"124"));
    }

    static long get(long n, long l, String s) {
        String N = Long.toString(n);
        long ans = 0;

        if (N.length() < s.length()) {
            return 0;
        } else if (N.length() > s.length()) {
            boolean ok = true;
            for (int i = 0; i < N.length() - s.length(); i++) {
                ok &= (N.charAt(i) - '0') <= l;
                long cur = Math.min(l + 1, Long.parseLong(String.valueOf(N.charAt(i))));

                if (i == (N.length() - s.length() - 1)) {
                    cur += (ok && (N.substring(N.length() - s.length()).compareTo(s) >= 0)) ? 1 : 0;
                }

                for (int j = i + 1; j < N.length() - s.length(); j++) {
                    cur *= l + 1;
                }

                ans += cur;

                if ((N.charAt(i) - '0') > l) {
                    break;
                }
            }
        } else {
            ans += N.compareTo(s) >= 0 ? 1 : 0;
        }

        return ans;
    }

    static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // Nahi samjha ye sum zara bhi
        return get(finish, limit, s) - get(start - 1, limit, s);
    }
}
