package Leetcode.Contest;

import java.util.*;

public class Is_it_possible_to_sort_the_array {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 5};
        System.out.println(check(3,5,arr));
    }

    public static boolean check(int D, int N, int[] A) {
        boolean[] vis = new boolean[N];
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < N; i++) {
            if(vis[i]) continue;
            int temp = i;

            // First it will add all the numbers with difference of a particular index.
            while (!vis[temp]){

                vis[temp] = true;
                if (!hm.containsKey(i)){
                    hm.put(i, new ArrayList<>());
                }
                hm.get(i).add(temp);
                temp = (temp+D)%N;
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            List<Integer> idxList = entry.getValue();
            List<Integer> tempLs = new ArrayList<>();

            for (int i = 0; i < idxList.size(); i++) {
                tempLs.add(A[idxList.get(i)]);
            }

            Collections.sort(tempLs);
            int k = 0;

            for(int idx: idxList){
                A[idx] = tempLs.get(k++);
            }
        }

        return isSorted(A);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}
