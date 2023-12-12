package Leetcode.Contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Strong_Students {
    public static void main(String[] args) {
        int[] a = {5,8,11,40,15};
        System.out.println(diffSum(a.length, 2, a));
    }

    public static int diffSum(int n,int m,int arr[]){
        //code here.
//        Arrays.sort(arr);
//        int s1 = 0, s2 = 0;
//
//        for (int i = 0; i < m; i++){
//            s1 += arr[i];
//        }
//
//        for (int i = n - 1; i >= n - m; i--){
//            s2 += arr[i];
//        }
//
//        return s1 > s2 ? s1 - s2 : s2 - s1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0;

        for(int a : arr){
            maxHeap.add(a);
            minHeap.add(a);
        }

        for (int i = 0; i < m; i++) {
            ans = maxHeap.poll() - minHeap.poll();
        }

        return ans;
    }
}
