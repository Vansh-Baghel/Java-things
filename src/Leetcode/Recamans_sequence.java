package Leetcode;

import java.util.*;

public class Recamans_sequence {
    public static void main(String[] args) {
        System.out.println(recamanSequence(8));
    }

    static ArrayList<Integer> recamanSequence(int n){
        // code here
        Set<Integer> hs = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        hs.add(0);

        for (int i = 1; i <= n; i++){
            int prev = res.get(res.size() - 1);
            if (prev - i < 0 || hs.contains(prev - i)) res.add(prev + i);
            else {
                res.add(prev - i);
            }

            hs.add(res.get(res.size() - 1));
        }

        return res;
    }
}
