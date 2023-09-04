package Stacks_Queues;

import java.util.*;

public class Queue_Reverse {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverse_firstK_Queue(q, 3);
    }

    static void reverseQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) st.push(q.poll());
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            q.add(st.pop());
        }
    }

    static void reverse_firstK_Queue(Queue<Integer> q, int k){
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // We are re-running the loop which will add the remaining element at the back of the reversed element.
        for (int i = 0; i < q.size() - k; i++) {
            int t = q.poll();
            q.add(t);
        }

        System.out.println(q);
    }
}
