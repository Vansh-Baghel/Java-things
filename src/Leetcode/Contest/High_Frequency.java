//https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-119/problems
package Leetcode.Contest;

import java.util.*;

public class High_Frequency {
    public static void main(String[] args) {
        String ans = solve(4, "dwlq");
        System.out.println(ans);
    }

    public static String solve(int N, String S) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        Character ans= ' ';

        for(char ch: S.toCharArray()){
            if (!hm.containsKey(ch)){
                hm.put(ch, 1);
            } else hm.put(ch, hm.get(ch)+1);
        }

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > max) {
                max=entry.getValue();
                ans = entry.getKey();
            } else if (entry.getValue() == max){
                int temp1 = (int)(ans);
                int temp2 = (int)(entry.getKey());
                if (temp1 > temp2) ans = entry.getKey();
            }
        }
        return ans+"";
    }
}
