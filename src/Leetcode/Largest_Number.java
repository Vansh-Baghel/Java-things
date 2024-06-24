package Leetcode;

import java.util.*;

public class Largest_Number {
    public static String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> compare(a, b));
        StringBuilder res = new StringBuilder();

        for (int num: nums){
            pq.add(num+"");
        }

        while (!pq.isEmpty()){
            res.append(pq.poll());
        }

        return res.toString();
    }

    public static int compare(String x, String y){
        int idx = 0;
        int minLength = Math.min(x.length(), y.length());

        while (idx < minLength && x.charAt(idx) == y.charAt(idx)) idx++;

        // Generally for decending order, agar first char is smaller than return -1, if equal return 0, if 2nd char greater, toh return 1.
        if (idx < minLength) return x.charAt(idx) < y.charAt(idx) ? 1 : -1;

        if (x.length() == minLength){
            if (x.charAt(idx - 1) < y.charAt(idx)) return 1;
            else return -1;
        } else {
            if (x.charAt(idx) < y.charAt(idx - 1)) return 1;
            else return -1;
        }
    }
}
