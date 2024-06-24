package Leetcode;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = {"ddddddddddg","dgggggggggg"};
        System.out.println(groupAnagrams(strs));
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        List<HashMap<Character, Integer>> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            list.add(new HashMap<>());

            for (char ch: strs[i].toCharArray()){
                list.get(i).put(ch, list.get(i).getOrDefault(ch, 0) + 1);
            }
        }

        int idx = -1;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> prevHm = list.get(i);

            if (vis[i]) continue;
            res.add(new ArrayList<>());

            idx++;
            for (int j = 0; j < n; j++) {
                HashMap<Character, Integer> curHm = list.get(j);

                if (prevHm.equals(curHm)) {
                    res.get(idx).add(strs[j]);
                    vis[j]=true;
                }
            }

            vis[i] = true;
        }

        return res;
    }

    static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            hm.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}
