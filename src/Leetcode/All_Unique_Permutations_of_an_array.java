package Leetcode;

import java.util.*;

public class All_Unique_Permutations_of_an_array {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        StringBuilder str = new StringBuilder();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        solve(0, n, vis, arr, list, res);
        return res;
    }

    static void solve(int idx , int n, boolean[] vis, ArrayList<Integer> arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        if (list.size() == n-1) {
            res.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < n - 1; i++){
            if (!vis[i] && !hs.contains(arr.get(i))){
                vis[i] = true;
                list.add(arr.get(i));
                hs.add(arr.get(i));
                solve(i + 1, n, vis, arr, list, res);
                vis[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
