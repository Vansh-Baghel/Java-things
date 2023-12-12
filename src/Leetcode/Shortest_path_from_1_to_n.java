package Leetcode;

import java.util.*;

public class Shortest_path_from_1_to_n {
    static class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        System.out.println(minStep(4));
    }

    static int minStep(int n) {
//        Queue<Pair> q = new LinkedList<>();
//        List<List<Pair>> adj = new ArrayList<>();
//
//        for (int i = 0; i <= n; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i <= n; i++) {
//            if (i + 1 <= n) adj.get(i).add(new Pair(1, i+ 1));
//            if (i * 3 <= n) adj.get(i).add(new Pair(1, i * 3));
//        }
//
//        int[] shortestPath = new int[n+1];
//        Arrays.fill(shortestPath, Integer.MAX_VALUE);
//
//        q.add(new Pair(1, 1));
//
//        while (!q.isEmpty()){
//            Pair top = q.poll();
//            int u = top.node;
//            int wt = top.distance;
//
//            for (Pair v: adj.get(u)){
//                int adjNode = v.node;
//                int adjWt = v.distance;
//                int totalWt = adjWt + wt;
//
//                if (totalWt < shortestPath[adjNode]){
//                    shortestPath[adjNode] = totalWt;
//                    q.add(new Pair(totalWt, adjNode));
//                }
//            }
//        }
//
//        return shortestPath[n] - 1;

        int ans = 0;

        while (n >= 3){
            ans += (n % 3) + 1;
            n /= 3;
        }

        return ans + (n - 1);
    }
}
