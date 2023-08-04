package Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //        All elements are unique, therefore using hashmap would be a good option.
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        //  Adding last element in the hashmap.
        hm.put(nums2[nums2.length-1],-1);
        //  Adding last element in the stack.
        st.push(nums2[nums2.length-1]);

        // Iterating the array backwards. Last element ka next is nothing, therefore always -1.
        for (int i = nums2.length - 2; i >= 0; i--) {
//            If stack is not empty and if stack ka peek value is smaller than the current value, means the next element of the current value is smaller, and therefore we will remove that element from the stack and attach -1 to the current value.
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                hm.put(nums2[i],-1);
            }
            else{
                hm.put(nums2[i],st.peek());
            }
//            This will push the current element into the stack so that it becomes new peek element of the stack.
            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length ;i++){
//            Getting the value from the key in hm and replacing the nums1 with those elements as answer ka length = nums1.length.
            nums1[i] = hm.get(nums1[i]);
        }
        return nums1;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans= new int[nums1.length];

        int[] nums2_greaterArr = nextGreaterElementOf2Arr(nums2);

        for (int i = 0; i < nums2_greaterArr.length; i++) {
            hm.put(nums2[i] , nums2_greaterArr[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }

    static int[] nextGreaterElementOf2Arr(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;
        ans[n -1] = -1;
        st.add(nums[n-1]);

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = -1;

            while (!st.isEmpty() && st.peek() < nums[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek() > nums[i]){
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}
