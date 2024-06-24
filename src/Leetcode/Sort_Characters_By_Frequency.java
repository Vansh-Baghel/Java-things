package Leetcode;
import java.util.*;

public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        System.out.println(frequencySort2("tree"));
    }

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















    static String frequencySort2(String s) {
        StringBuilder res = new StringBuilder();
//        int[][] freq = new int[26][2];
        int[][] freq = new int[256][2];

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch][0]++;
            freq[ch][1] = ch;
        }

        // -a[0] for descending order
        Arrays.sort(freq, Comparator.comparingInt(a -> -a[0]));

        for(int i = 0; i < 256; i++){
            if (freq[i][0] == 0) break;
            for (int j = 0; j < freq[i][0]; j++) {
                res.append((char)freq[i][1]);
            }
        }

        return res.toString();
    }
}
