package Leetcode;

import java.util.Stack;

public class Min_Stack {
    Stack<Integer> st= new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int val) {
        if (st.isEmpty()){
            st.push(val);
            min.push(val);
        } else {
            if (min.peek() < val) min.push(min.peek());
             else min.push(val);
             st.push(val);
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
