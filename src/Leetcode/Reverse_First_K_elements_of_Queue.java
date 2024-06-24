package Leetcode;

import java.util.*;

public class Reverse_First_K_elements_of_Queue {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Queue<Integer> res = new LinkedList<>();
        Stack<Integer> st= new Stack<>();

        while (k != 0) {
            st.add(q.poll());
            k--;
        }

        while (!st.isEmpty()) res.add(st.pop());

        while (!q.isEmpty()) res.add(q.poll());

        return res;
    }
}
