package Leetcode;

import java.util.*;

public class Find_Players_With_Zero_or_One_Losses {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9}
        };

        System.out.println(findWinners(arr));
    }

    static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int[] match : matches) {
            int loser = match[1];
            hm.put(loser, hm.getOrDefault(loser, 0) + 1);
            winners.add(match[0]);
        }

        List<Integer> atLeastOneLost = new ArrayList<>(), noneLost = new ArrayList<>();

        for (var e : hm.entrySet()) {
            int v = e.getValue();

            if (v == 1) atLeastOneLost.add(e.getKey());
        }

        for (Integer it : winners) {
            if (!hm.containsKey(it)) noneLost.add(it);
        }

        Collections.sort(noneLost);
        Collections.sort(atLeastOneLost);

        res.add(noneLost);
        res.add(atLeastOneLost);
        return res;
    }

    public List<List<Integer>> findWinners2(int[][] matches) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            if (!hm.containsKey(winner)) hm.put(winner, 0);
            hm.put(loser, hm.getOrDefault(loser, 0) + 1);
        }

        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (var e : hm.entrySet()) {
            int v = e.getValue();

            if (v == 1) res.get(0).add(e.getKey());
            else if (v == 0) res.get(1).add(e.getKey());
        }

        for (int i = 0; i < 2; i++) {
            Collections.sort(res.get(i));
        }
        return res;
    }
}
