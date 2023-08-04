package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Remove_Consecutive_Subsequences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};

        int[] ans= removeConsecutive(arr);

        System.out.println(Arrays.toString(ans));
    }

    static int[] removeConsecutive(int[] arr){
        Stack<Integer> st = new Stack<>();
        int i = 1;
        if(arr.length == 0 || arr.length == 1) return arr;

        st.push(arr[0]);

        while (i < arr.length) {
            if (!st.isEmpty() && st.peek() != arr[i]){
                st.push(arr[i]);
            } else {
                while (arr[i] == arr[i + 1]){
                    i++;
                }
                st.pop();
            }
            i++;
        }

        int[] ans = new int[st.size()];

        while (!st.isEmpty()){
            for (int j = ans.length - 1; j >= 0; j--) {
                ans[j] = st.pop();
            }
        }
        return ans;
    }

    // Better, cleaner
    static int[] removeConsecutive2(int[] arr){
        Stack<Integer> st = new Stack<>();
        if(arr.length == 0 || arr.length == 1) return arr;

        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty() || st.peek() != arr[i]) st.push(arr[i]);
            if (st.peek() == arr[i]){
                // If i last element hai, and if stack ka peek and ye equal hai, then just pop krdo stack wala.
                // If arr[i] and arr[i+1] equal hai, toh kuchh mat kro. As soon as arr[i] and arr[i+1] unequal hue, pop the stack.
                if (i == arr.length - 1 || arr[i] != arr[i+1]) st.pop();
            }
        }

        int[] ans = new int[st.size()];

        while (!st.isEmpty()){
            for (int j = ans.length - 1; j >= 0; j--) {
                ans[j] = st.pop();
            }
        }
        return ans;
    }
}
