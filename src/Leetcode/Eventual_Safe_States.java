package Leetcode;
import java.util.*;

public class Eventual_Safe_States {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                detectCycle(adj, ans, i, vis, pathVis);
            }
        }


        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 1){
                list.add(i);
            }
        }

        return list;
    }

    private static boolean detectCycle(List<List<Integer>> adj, int[] ans, int node, boolean[] vis, boolean[] pathVis) {
        pathVis[node] = true;
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (detectCycle(adj,ans, it, vis, pathVis)) {
                    // if cycle is detected, means it cannot be safe state.
                    ans[it] = 0;
                    return true;
                }
            }
            // means both vis and pathVis is true.
            else if (pathVis[it]) {
                ans[it] = 0;
                return true;
            }
        }
            // If no cycle is detected, this condition will run. Make the ans as 1.
            ans[node] = 1;

        // this condition will run when there are no adj left.
        pathVis[node] = false;
        return false;
    }
}
