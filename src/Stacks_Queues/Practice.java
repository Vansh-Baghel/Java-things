package Stacks_Queues;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

//        displayRec(st);
//        System.out.println();
//        reverse(st);
//        reverseRec(st);
        insertAtBottom(st, 0);
        display(st);
    }

    private static void insertAtBottom(Stack<Integer> st, int num) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) temp.push(st.pop());
        st.push(num);
        while (!temp.isEmpty()) st.push(temp.pop());
    }

    private static void reverseRec(Stack<Integer> st) {
        int top = st.pop();
        reverse(st);
    }

    private static void reverse(Stack<Integer> st) {
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();

        while (!st.isEmpty()){
            temp1.push(st.pop());
        }

        while (!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }

        while (!temp2.isEmpty()){
            st.push(temp2.pop());
        }
    }

    private static void display(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        while(!temp.isEmpty()) System.out.print(temp.pop() + " ");
    }

    private static void displayRec(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        };

        int top = st.pop();
        // Printing from top to bottom.
//        System.out.print(top + " ");

        displayRec(st);
        // Printing from bottom to top.
        System.out.print(top + " ");
        st.push(top);
    }
}
