package Leetcode;

import java.util.ArrayList;

public class Find_if_Path_Exists_in_Graph {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(src, des, adj, vis);
    }

    public boolean dfs(int u, int des, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if (u == des) return true;
        vis[u] = true;

        for (int v: adj.get(u)){
            if (!vis[v] && dfs(v, des, adj, vis)){
                return true;
            }
        }

        return false;
    }
}
