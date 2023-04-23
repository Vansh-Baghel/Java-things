package Leetcode.LinkedList;
import java.util.*;

public class Relative_Ranks {
    public String[] findRelativeRanks(int[] score) {
        String ans[] = new String[score.length];

        // This will sort the arrray in decending order.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<score.length;i++) pq.add(score[i]);

        HashMap<Integer, String> hm = new HashMap<>();

        // They want the indices of answer in 1 format, so index needs to be started from 1.
        int i = 1;

        while (!pq.isEmpty()){
            if (i == 1){
                // pq.remove() will return the very first element in the queue by FIFO and as we have stored the nums in descendin order in queue, it will always be the largest num.
                hm.put(pq.remove(), "Gold Medal");
            }
            else if (i == 2){
                hm.put(pq.remove(), "Silver Medal");
            }
            else if (i == 3){
                hm.put(pq.remove(), "Bronze Medal");
            }
            else{
                hm.put(pq.remove(),Integer.toString(i));
            }
            i++;
        }

        // Storing the nums in answer array.
        for(int j = 0; j < score.length ; j++){
            ans[j] = hm.get(score[j]);
        }

        return ans;
    }
}
