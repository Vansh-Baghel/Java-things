package Leetcode;

import java.util.*;

public class Find_the_Winner_of_the_Circular_Game {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++){
            q.add(i);
        }

        while (q.size() > 1){
            for (int i = 0; i < k - 1; i++){
                q.add(q.poll());
            }
            q.poll();
        }

        return q.poll();
    }
}
