package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {
    public static class Disjoint_2{
        int[] rank;
        int[] parent;

        public Disjoint_2(int size){
            this.rank = new int[size];
            this.parent = new int[size];

            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if (parent[i] == i) return i;

            return parent[i] = findParent(parent[i]);
        }

        public void unionByRank(int u, int v){
            int parent_u = findParent(u);
            int parent_v = findParent(v);

            if (parent_u == parent_v) return;

            if (rank[parent_u] == rank[parent_v]){
                parent[parent_v] = parent_u;
                rank[parent_u]++;
            } else if (rank[parent_u] > rank[parent_v]){
                parent[parent_v] = parent_u;
            } else parent[parent_u] = parent_v;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};

        System.out.println(countPairs(n, edges));
    }

    static long countPairs(int n, int[][] edges) {
        Disjoint_2 ds = new Disjoint_2(n);
        HashMap<Integer, Integer> hm = new HashMap<>();
//        int totalUniquePairs = n;
        long ans = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (ds.findParent(u) != ds.findParent(v)) {
                ds.unionByRank(u, v);
//                totalUniquePairs--;
            }
        }

        for (int i = 0; i < n; i++) {
            int parent_i = ds.findParent(i);
            hm.put(parent_i, hm.getOrDefault(parent_i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            // Integer parent = entry.getKey();
            Integer curPairSize = entry.getValue();
            ans += (long) (curPairSize) * (n - curPairSize);
            n -= curPairSize;
        }

        return ans;
    }
}
