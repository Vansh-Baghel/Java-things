package Leetcode;

import java.util.*;

public class Find_duplicates_in_an_array {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        HashSet<Integer> hm = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int el = arr[i];
            if (hm.contains(el) && !ans.contains(el)) ans.add(el);
            else hm.add(el);
        }

        if (ans.size() == 0) ans.add(-1);
        Collections.sort(ans);
        return ans;
    }
}
