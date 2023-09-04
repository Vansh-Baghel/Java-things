package Leetcode;
import java.util.*;

public class Implement_Stack_using_Queues {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> t = new LinkedList<>();
    int size = 0;

    public void MyStack() {
        // constructor
    }

    // Using 2 queues
//    public void push(int x) {
//        q.add(x);
//        size++;
//    }
//
//    public int pop() {
//        while (q.size() != 1) t.add(q.poll());
//        int top = q.poll();
//        while (!t.isEmpty()) q.add(t.poll());
//        size--;
//        return top;
//    }
//
//    public int top() {
//        while (q.size() != 1) t.add(q.poll());
//        int top = q.poll();
//        while (!t.isEmpty()) q.add(t.poll());
//
//        // Readding the top element so it goes behind the elements transferred from temp.
//        q.add(top);
//        return top;
//    }
//
//    public boolean empty() {
//        return size == 0;
//    }

    // Using 1 queue

    public void push(int x) {
        q.add(x);
        size++;
    }

    public int pop() {
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
        int top = q.poll();
        size--;
        return top;
    }

    public int top() {
        // Running till the size is not 1. We are adding and removing in the same queue, so it gets removed from front and get added behind.
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
        int top = q.poll();
        q.add(top);
        return top;
    }

    public boolean empty() {
        return size == 0;
    }
}
