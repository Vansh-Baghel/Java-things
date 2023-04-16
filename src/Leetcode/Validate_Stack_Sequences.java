package Leetcode;

import java.util.Stack;

public class Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);

            while (!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }
}
