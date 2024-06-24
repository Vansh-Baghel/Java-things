package Leetcode.Contest;

import java.util.*;

public class Array_Game {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] brr = {2,1,3};
        int n = arr.length;
        System.out.println(min_operations2(n, arr, brr));
    }

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // Wrong
    public static int min_operations(int n, int[] arr, int[] brr) {
        // code here
        int idx = 0, cnt = 0;

        while (idx < n && !Arrays.equals(arr,brr)){
            if (arr[idx] != brr[idx]){
                int t = arr[idx];

                for (int i = idx + 1; i < n; i++) arr[i - 1] = arr[i];

                arr[n-1] = t;
            }
            cnt++;
            idx++;
        }
        return cnt + idx;
    }

    public static int min_operations2(int n, int[] arr, int[] brr) {
        int cnt = 0, idx = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int num: arr) q.add(num);

        while (idx < n && !q.isEmpty()) {
            cnt++;
            int top = q.poll();

            if (top == brr[idx]) idx++;
            else q.add(top);
        }

        return cnt;
    }
}
