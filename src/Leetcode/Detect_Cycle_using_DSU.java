package Leetcode;
import java.util.*;

public class Detect_Cycle_using_DSU {
    public class Disjoint_2 {
        int[] rank;
        int[] parent;
        public Disjoint_2(int n) {
            this.rank = new int[n];
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                this.rank[i] = 0;
                this.parent[i] = i;
            }
        }

        public void unionByRank2(int u, int v){
            int parent_u = findParent(u);
            int parent_v = findParent(v);

            if (parent_u == parent_v) return;

            if (rank[parent_u] == rank[parent_v]) {
                parent[parent_v] = parent_u;
                rank[parent_u]++;
            } else if (rank[parent_u] > rank[parent_v]){
                parent[parent_v] = parent_u;
            } else {
                parent[parent_u] = parent_v;
            }
        }

        public int findParent(int i){
            if (i == parent[i]) return i;

            return parent[i] = findParent(parent[i]);
        }
    }

    int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Disjoint_2 ds = new Disjoint_2(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int n = adj.get(i).get(j);

                if (ds.findParent(i) != ds.findParent(n)) {
                    ds.unionByRank2(i, n);
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }
}
