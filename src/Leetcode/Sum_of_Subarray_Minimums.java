package Leetcode;

import java.util.*;

public class Sum_of_Subarray_Minimums {
    public static void main(String[] args) {
        int[] arr = {71,55,82,55};
        System.out.println(sumSubarrayMins2(arr));
    }

    static int res = 0;
    static int mod = (int)1e9+7;

    static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            solve(i, Integer.MAX_VALUE, n, arr);
        }
        int tmp = res%mod;
        res = 0;
        return tmp;
    }

    static void solve(int idx, int mini, int n, int[] arr){
        if (idx == n) {
            return;
        }

        mini = Math.min(mini, arr[idx]);
        solve(idx + 1, mini, n, arr);
        res = (res + mini)%mod;
    }

    static int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] nsl = new int[n], nsr = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
//            if (st.isEmpty()) nsl[i] = -1;
//            else nsl[i] = st.peek();

            nsl[i] = st.isEmpty() ? -1 : st.peek();

            st.add(i);
        }

        st = new Stack<>();

        for (int i = n - 1; i >= 0; i--){
            // We have to consider one of the conditions where it is equal to the peek, because in example 2,3,2,5,2; there could be duplicates.
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

//            if (st.isEmpty()) nsr[i] = n;
//            else nsr[i] = st.peek();

            nsr[i] = st.isEmpty() ? n : st.peek();

            st.add(i);
        }

            for (int i = 0; i < n; i++){
                long left = i - nsl[i];
                long right = nsr[i] - i;

                // These are the totalWays in which the cur num is the smallest
                long totalWays = left * right;

                // To add in the result, we need to multiply it with the current num because the cur num is the smallest in the given range.
                long curTotal = arr[i] * totalWays;

                res = (int)(res + curTotal) % mod;
            }

            return res;
    }
}
