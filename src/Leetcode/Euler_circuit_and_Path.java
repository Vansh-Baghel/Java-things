package Leetcode;

import java.util.*;

public class Euler_circuit_and_Path {
    public int isEulerCircuitExist(int V, ArrayList<ArrayList<Integer>> adj){
        int nonZero = -1, oddDegreeCount=0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() != 0){
                nonZero = i;
                break;
            }
        }

        isEulerianPathDFS(nonZero, adj, vis);

        for (int i = 0; i < V; i++) {

            // adj.get(i).size() > 0 because if there are nodes which are not connected to each other and are separate from the main graph, still it is euler path. Euler path says that all the edges should be visited.
            if (!vis[i] && adj.get(i).size() > 0) return 0;
            if (adj.get(i).size() % 2 != 0) oddDegreeCount ++;
        }

        if (oddDegreeCount > 2) return 0;
        if (oddDegreeCount == 2) return 1;

        return 2;
    }

    private static void isEulerianPathDFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[u] = true;

        for (int v: adj.get(u)){
            if (!vis[v]) {
                isEulerianPathDFS(v, adj, vis);
            }
        }
    }

    static int isEulerCircuit(int V, List<Integer>[] adj) {
        int nonZero = -1, oddCounts=0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) nonZero = i;
            break;
        }

        dfs(nonZero, vis, adj);

        for (int i = 0; i < V; i++) {
            if (!vis[i] && adj[i].size() > 0) return 0;
            if (adj[i].size() % 2 != 0) oddCounts++;
        }

        if (oddCounts == 2 && V != 2) return 1;
        if (oddCounts > 2) return 0;
        return 2;
    }

    static void dfs(int u, boolean[] vis, List<Integer>[] adj) {
        vis[u] = true;

        for (int v: adj[u]){
            if (!vis[v]){
                dfs(v, vis, adj);
            }
        }
    }
}
