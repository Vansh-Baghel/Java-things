package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int ans = largestRectangleArea(nums);
        System.out.println(ans);
    }

    static int largestRectangleArea(int[] heights) {
        int[] nse = nextSmallerElement(heights);
        int[] pse = prevSmallerElement(heights);
        int max= 0;

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // By default we have kept it n and not -1, so that we could calculate the difference.
            ans[i] = n;
            if (!st.isEmpty() && nums[i] < nums[st.peek()]){
                while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                    ans[st.pop()] = i;
                }
            }
            st.push(i);
        }
        return ans;
    }

    static int[] prevSmallerElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans[i] = -1;

            // Smaller and equal for arrays like {0,2,2} where prev small of last num is 0, but it won't be popped if equal nhi rakha toh in the condition
            if (!st.isEmpty() && nums[i] <= nums[st.peek()]){
                while(!st.isEmpty() && nums[i] <= nums[st.peek()]){
                    st.pop();
                }
            } if (!st.isEmpty() && nums[i] > nums[st.peek()]) ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
}