package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Unique_Number_of_Occurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }
    static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int num: arr) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry: hm.entrySet()){
            if(!hs.add(entry.getValue())) return false;
            hs.add(entry.getValue());
        }

        return true;
    }
}
