package Leetcode;

import java.util.*;

public class Daily_Temperatutes {
    public static void main(String[] args) {
        int[] arr= {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        // Starting from start of the root.
        for (int i = 0; i < temperatures.length; i++) {
            // We are storing the index numbers in the stack therefore if the stack ka peek is smaller than current index, means we found the first bigger num.
            // NOTE: This is a while loop which will remove every
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // We will remove the topmost index, and store it in variable index.
                int index = stack.pop();
                // Then at that topmost index, we will store the answer which is the difference between the i and index.
                ans[index] = i - index;
            }
            // We are pushing into stack after everything.
            stack.push(i);
        }
        return ans;
    }
}
