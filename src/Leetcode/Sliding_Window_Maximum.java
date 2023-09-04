package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int n = nums.length;
        int z = 0;
        int[] nge = nextGreaterEl1(nums);
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < n + 1 - k; i++) {
            int j = i;
            int max = nums[j];

            while (j < i + k){
                max = nums[j];
                j = nge[j];
            }
            ans[z++] = max;
        }
        System.out.println(Arrays.toString(nge));
        return ans;
    }

    static int[] nextGreaterEl1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans[i] = n;
            if (!st.isEmpty() && nums[i] > nums[st.peek()]){
                while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                    ans[st.pop()] = i;
                }
            }
            st.push(i);
        }
        return ans;
    }
}
