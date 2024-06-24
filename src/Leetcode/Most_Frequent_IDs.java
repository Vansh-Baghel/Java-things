package Leetcode;

import java.util.*;

public class Most_Frequent_IDs {
//    public static class Pair{
//        long first;
//        long second;
//
//        Pair(long first, long second){
//            this.first = first;
//            this.second = second;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,1}, freq = {3,2,-3,1};
        System.out.println(Arrays.toString(mostFrequentIDs(nums, freq)));
    }

    public static long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] res = new long[n];
        HashMap<Long, Long> hm = new HashMap<>();
        PriorityQueue<long[]> mH = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int i = 0; i < n; i++){
            long ID = nums[i];
            long fq = freq[i];

            hm.put(ID, hm.getOrDefault(ID, 0L) + fq);
            mH.add(new long[]{hm.get(ID), ID});

            while (!mH.isEmpty() && (hm.get(mH.peek()[1]) != mH.peek()[0])){
                mH.poll();
            }

            res[i] = mH.peek()[0];
        }

        return res;
    }
}
