package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Disjoint_2 {
    int[] rank;
    int[] parent;
    int[] size;
    public Disjoint_2(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public void unionByRank(int u, int v){
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

    public void unionBySize(int u, int v){
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) return;

        if (size[parent_u] == size[parent_v]) {
            parent[parent_v] = parent_u;
            size[parent_u]+=size[parent_v];
        } else if (size[parent_u] > size[parent_v]){
            parent[parent_v] = parent_u;
            size[parent_u]+=size[parent_v];
        } else {
            parent[parent_u] = parent_v;
            size[parent_v]+=size[parent_u];
        }
    }

    public int findParent(int i){
        if (i == parent[i]) return i;

        return parent[i] = findParent(parent[i]);
    }
}
