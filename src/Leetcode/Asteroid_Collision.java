package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision {
    public static void main(String[] args) {
        int[] arr = {-2,-2,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int num: asteroids){
            // 1st way
//            if (st.isEmpty() || st.peek() < 0 && num > 0 || st.peek() > 0 && num > 0 || st.peek() < 0 && num < 0) st.add(num);
//            else {
//                if (st.peek() > 0){
//                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < num * -1) st.pop();
//                }
//                if (st.isEmpty() || st.peek() < 0) st.add(num);
//                else if (st.peek() < num * -1) st.pop();
//
//            }

            // 2nd way
            while (!st.isEmpty() && num < 0 && st.peek() > 0){
                int sum = num + st.peek();
                if (sum > 0) num = 0;
                else if (sum < 0) {
                    st.pop();
                } else {
                    st.pop();
                    num = 0;
                }
            }
            if (num != 0) st.add(num);
        }

        int n = st.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[n-i-1] = st.pop();
        }
        return ans;
    }
}
