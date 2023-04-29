package Leetcode;
import java.util.*;

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        HashMap<Character , Integer> hm = new HashMap<>();
        String ans = "";

        for (char ch : s.toCharArray()){
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);
        }

        // MaxHeap PriorityQueue
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> hm.get(b)-hm.get(a));
        // Adding all the keys at once in pq.
        pq.addAll(hm.keySet());

        while (!pq.isEmpty()){
            char cur= pq.remove();
            int freq = hm.get(cur);

            // Appending the string till its freq becomes 1.
            while (freq > 0){
                ans += cur;
                freq--;
            }
        }

        return ans;
    }
}
