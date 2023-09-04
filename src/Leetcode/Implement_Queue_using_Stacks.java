package Leetcode;

import java.util.Stack;

public class Implement_Queue_using_Stacks {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int size = 0;

    public void MyQueue() {

    }

    public void push(int x) {
        st1.add(x);
        size++;
    }

    public int pop() {
        while (st1.size() != 1) st2.add(st1.pop());
        int top = st1.pop();
        while (!st2.isEmpty()) st1.add(st2.pop());
        size--;
        return top;
    }

    public int top() {
        while (st1.size() != 1) st2.add(st1.pop());
        int top = st1.pop();
        st1.add(top);
        while (!st2.isEmpty()) st1.add(st2.pop());

        // Readding the top element so it goes behind the elements transferred from temp.
        return top;
    }

    public boolean empty() {
        return size == 0;
    }
}
