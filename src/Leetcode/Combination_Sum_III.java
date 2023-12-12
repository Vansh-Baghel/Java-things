package Leetcode;

import java.util.*;

public class Combination_Sum_III {
    public static void main(String[] args) {
        System.out.println(combinationSum3(9,45));
    }

    static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombinations(1, 0, 0, n, k, list, ans);
        return ans;
    }

    private static void getAllCombinations(int idx, int sum, int size, int n, int k, List<Integer> list, List<List<Integer>> ans) {
        if (sum == n && size == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < 10; i++) {
            if (sum > n || sum < n && k < size) break;

            list.add(i);
            getAllCombinations(i + 1, sum + i, size + 1, n, k, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
