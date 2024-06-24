package Leetcode;

import java.util.*;

public class Insert_Delete_GetRandom {
    class RandomizedSet {
        HashMap<Integer, Integer> hm;
        List<Integer> list;

        public RandomizedSet() {
            hm = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (hm.containsKey(val)) return false;
            list.add(val);
            int idx = list.size() - 1;

            hm.put(val, idx);
            return true;
        }

        public boolean remove(int val) {
            if (!hm.containsKey(val)) return false;

            // Making changes because we are going to remove the el, so we need to change the index in the hm as well.
            int n = list.size() - 1;
            int lastEl = list.get(n);
            int idx = hm.get(val);
            hm.put(lastEl, idx);
            list.set(idx, lastEl);
            list.remove(n);
            hm.remove(val);
            return true;
        }

        public int getRandom() {
            Random rndm = new Random();
            int idx = rndm.nextInt(list.size());
            return list.get(idx);
        }
    }
}
