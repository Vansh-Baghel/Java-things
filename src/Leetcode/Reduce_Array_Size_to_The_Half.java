package Leetcode;
import java.util.*;

public class Reduce_Array_Size_to_The_Half {
    public int minSetSize(int[] arr) {
        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        // MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int removedLength = 0;
        int count = 0;

        // Storing all nums in hashMap.
        for(int num: arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Storing all counts in MaxHeap.
        for (int val: hm.values()){
            pq.offer(val);
        }

        while (removedLength < arr.length / 2){
            // Adding the occurance in removedLength to maintain the number about how much numbers are removed.
            removedLength += pq.poll();
            // count the number of times we removed any number.
            count++;
        }
        return count;
    }
}
