package Leetcode;

import java.util.*;

public class Largest_3_Same_Digit_Number_in_String {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger2("1221000"));
    }

    static String largestGoodInteger(String num) {
        String ans = "";
        int n = num.length(), maxi = -1;

        for (int e = 1; e < n - 1; e++) {
            String cur = num.charAt(e) + "";
            String nxt = num.charAt(e+1) + "";
            String prev = num.charAt(e-1) + "";

            if (cur.equals(nxt) && cur.equals(prev)) {
                if (maxi < Integer.parseInt(cur)){
                    maxi = Integer.parseInt(cur);
                    ans = num.substring(e-1, e+2);
                }
            }
        }

        return ans;
    }

    static String largestGoodInteger2(String num) {
        String ans = "";
        int n = num.length(), maxi = -1, s = 0;
        Queue<String> q = new LinkedList<>();

        for (int e = 0; e < n; e++) {
            String str = num.charAt(e) + "";
            if (q.isEmpty()) {
                q.add(str);
                continue;
            }

            if (q.peek().equals(str)){
                if ((e - s) + 1 == 3){
                    int convertedInt = Integer.parseInt(str);
                    if (convertedInt > maxi){
                        maxi = convertedInt;
                        ans = num.substring(s, e+1);
                    }
                }
            } else {
                q.poll();
                q.add(str);
                s=e;
            }
        }

        return ans;
    }

    static String largestGoodInteger3(String num) {
        int[] digits = new int[10];

        for (int i = 0; i < 3; i++) {
            digits[num.charAt(i) - '0']++;
        }

        // since k = 3 is given
        int s = 0, e = 3-1, n = num.length();
        char max = '.';

        while (e < n){
            char curChar = num.charAt(e);
            int curCnt = digits[curChar - '0'];
            if (curCnt == 3 && max < curChar){
                max = curChar;
            }
            digits[num.charAt(s++)]--;
            if (++e < n) digits[num.charAt(s++)]++;
        }

        return max == '.' ? "" : (max+"").repeat(3);
    }
}
