package Leetcode;

import java.util.*;

public class Top_K_Frequent_Elements_in_Array {
//    public class Pair{
//        int first;
//        int sec;
//
//        public Pair(int first, int sec){
//            this.first = first;
//            this.sec = sec;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topK(nums, k)));
    }

    static int[] topK(int[] nums, int k) {
        // Code here
        int[] ans = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue(); //  frequency in asc
            } else {
                return a.getKey() - b.getKey(); // if freq same, sort by key in asc
            }
        });

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> mp: hm.entrySet()) {
            minHeap.add(mp);
            if(minHeap.size()>k) minHeap.poll();
        }

        int idx=k-1;
        while (!minHeap.isEmpty()) {
            ans[idx--] = minHeap.poll().getKey();
        }
        return ans;
    }
}
