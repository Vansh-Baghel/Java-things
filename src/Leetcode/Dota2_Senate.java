package Leetcode;

import java.util.*;

public class Dota2_Senate {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR"));
    }

    static String predictPartyVictory(String senate) {

        int dCount = 0, dBan = 0, rCount = 0, rBan = 0;
        Queue<Character> q = new LinkedList<>();

        for (char ch : senate.toCharArray()) {
            if (ch == 'D') dCount++;
            else rCount++;
            q.add(ch);
        }

        while (rCount > 0 && dCount > 0){
            char ch = q.poll();

            if (ch == 'D'){
                if (dBan > 0) {
                    dBan--;
                    dCount--;
                }else{
                    rBan++;
                    q.add(ch);
                }
            } else {
                if (rBan > 0) {
                    rBan--;
                    rCount--;
                } else{
                    dBan++;
                    q.add(ch);
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}
