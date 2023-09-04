package Leetcode;

import java.util.Stack;

public class The_Celebrity_Problem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1},
                {0, 0, 0},
                {0, 1, 0}
        };

        int ans = celebrity(matrix, 3);
        System.out.println(ans);
    }
    static int celebrity(int M[][], int n){
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1){
            int v1 = st.pop();
            int v2 = st.pop();

            if (M[v1][v2] == 1){
                st.push(v2);
            } else if (M[v2][v1] == 1){
                // Removing the second one.
                st.push(v1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || i != st.peek() && M[i][st.peek()] != 1) return -1;
            if (M[st.peek()][i] != 0) return -1;
        }

        return st.peek();
    }
}
