package Leetcode;

import java.util.*;

public class Is_it_a_tree {
    public int total = 0;

    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        // This will take care of cycle. If cycle exists, edges will not be equal to node - 1.
        if (m != n - 1) return false;

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge: edges){
            int u = edge.get(0), v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        solve(vis, 0, adj);

        // If the total visited nodes are same as that of given n nodes, means we visited all the nodes.
        int tmp = total;
        total = 0;
        return tmp == n;
    }

    public void solve(boolean[] vis, int node, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        total++;

        for (int it: adj.get(node)){
            if (!vis[it]){
                solve(vis, it, adj);
            }
        }
    }
}
