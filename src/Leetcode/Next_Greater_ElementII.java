//package Leetcode;
//
//import java.util.Arrays;
//import java.util.Stack;
//
//public class Next_Greater_ElementII {
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        int[] ans = nextGreaterElements(arr);
//        System.out.println(Arrays.toString(ans));
//    }
//    static int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        Stack<Integer> st = new Stack<>();
//
//        for (int i = 0; i < n - 1; i++) {
//            ans[i]= -1;
//            for (int j = i; j < n; j++) {
//                if (!st.isEmpty() && st.peek() > nums[i]){
//                    st.push(nums[j]);
//                    ans[i] = st.peek();
//                    break;
//                }
//                else if (nums[j] > nums[i]){
//                    st.push(nums[j]);
//                    ans[i] = nums[j];
//                     break;
//                }
//            }
//        }
//        ans[n-1]=-1;
//        for (int i = 0; i < n - 1; i++) {
//            if (nums[n - 1] < nums[i]) ans[n-1] = nums[i];
//        }
//
//        return ans;
//    }
//}
