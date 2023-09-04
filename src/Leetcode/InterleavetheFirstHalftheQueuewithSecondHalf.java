package Leetcode;
import java.util.*;

public class InterleavetheFirstHalftheQueuewithSecondHalf {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> ans = rearrangeQueue(8, a);
        System.out.println(ans);
    }
    static ArrayList<Integer> rearrangeQueue(int N, int[] q) {
        // Usign arrays
//        ArrayList<Integer> ans = new ArrayList<>();
//        int m = q.length / 2;
//        for (int i = 0; i < m; i++) {
//            ans.add(q[i]);
//            ans.add(q[i+m]);
//        }
//        return ans;
        
        // Using stacks and queue.
        Stack<Integer> st = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int m = N / 2;
        ArrayList<Integer> ans = new ArrayList<>();

        // Adding all el in queue initially
        for (int i = 0; i < N; i++) {
            queue.add(q[i]);
        }

        // Adding el from 0 to mid in stack.
        addInStackTillMid(st, queue, m);

        // Joining the queue with the stack elements which will be pushed from the back in queue.
        while(!st.isEmpty()) {
            queue.add(st.pop());
        };

        // Adding el from 0 to mid in stack again
        addInStackTillMid(st, queue, m);

        while(!st.isEmpty()) {
            queue.add(st.pop());
            queue.add(queue.poll());
        };

        // Reversing the queue
        reverseTheQueue(queue, st, ans);

        return ans;
    }

    private static void addInStackTillMid(Stack<Integer> st, Queue<Integer> queue, int m) {
        for (int i = 0; i < m; i++) {
            st.add(queue.poll());
        }
    }

    static void reverseTheQueue(Queue<Integer> queue, Stack<Integer> st, ArrayList<Integer> ans) {
        while (!queue.isEmpty()) st.push(queue.poll());
        while (!st.isEmpty()) queue.add(st.pop());
        while (!queue.isEmpty()) ans.add(queue.poll());
    }


}
