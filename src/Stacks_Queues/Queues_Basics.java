package Stacks_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Queues_Basics {
    public static class queue{
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> helper = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            helper.add(q.poll());
        }
        while (!helper.isEmpty()){
            q.add(helper.poll());
        }
    }
}
