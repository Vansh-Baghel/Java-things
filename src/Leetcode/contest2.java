package Leetcode;
import java.util.*;

public class contest2 {
    ArrayList<Integer> arr = new ArrayList<>();

    public contest2() {
        this.arr = arr;
    }

    public void add(int number) {
        arr.add(number);
    }

    public void deleteOne(int number) {
        if (arr.contains(number)) arr.remove(number);
        else return;
    }

    public boolean hasFrequency(int frequency) {
        HashMap<Integer , Integer> hm = new HashMap<>();

        for (int num: arr){
            hm.put(num , hm.getOrDefault(num, 0) + 1);
        }

        for (int num: arr){
            if (hm.get(num) == frequency){
                return true;
            }
        }

        return false;
    }
}
