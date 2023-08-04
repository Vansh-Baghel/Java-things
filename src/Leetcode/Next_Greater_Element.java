package Leetcode;

import java.util.*;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int[] nums = {1,3,2,1,8,6,3,4};
        int[] ans = nextGreaterEl1(nums);
        System.out.println(Arrays.toString(ans));
    }

    // Traverse from back to front.
    static int[] nextGreaterEl(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        ans[n-1] = -1;
        st.add(nums[n-1]);
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = -1;
            while (!st.isEmpty() && st.peek() < nums[i]){
                st.pop();
            }
            if (!st.isEmpty() && st.peek() > nums[i]) {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }

    // Traverse from start till end
    static int[] nextGreaterEl1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            if (!st.isEmpty() && nums[i] > nums[st.peek()]){
                while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                    ans[st.pop()] = nums[i];
                }
            }
            st.push(i);
        }
        return ans;
    }
}
