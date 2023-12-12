package Leetcode;
import java.util.*;

public class Strongly_Connected_Components {
    static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        // Steps:
        // 1. Fill Stack for Topological Sort
        // 2. Reverse the graph
        // 3. Dfs chalao from stack elements on reversedGraph

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        // 1. Topo hogya
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                topoSort(i, st, vis, adj);
            }
        }

        // 2. Reverse the adj
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            reversedAdj.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v: adj.get(u)){
                reversedAdj.get(v).add(u);
            }
        }

        // 3. Stack se normal dfs lagao, and count badha te jaao
        int countStronglyConnectedComponents = 0;
        Arrays.fill(vis, false);

        while (!st.isEmpty()){
            int u = st.pop();

            if(!vis[u]){
                dfsTraversal(u, vis, reversedAdj);
                countStronglyConnectedComponents++;
            }
        }

        return countStronglyConnectedComponents;
    }

    private static void dfsTraversal(int u, boolean[] vis, ArrayList<ArrayList<Integer>> reversedAdj) {
        vis[u]= true;

        for (int v: reversedAdj.get(u)){
            if (!vis[v]){
                dfsTraversal(v, vis, reversedAdj);
            }
        }
    }

    static void topoSort(int u, Stack<Integer> st, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = true;

        for (int v: adj.get(u)){
            if (!vis[v]) {
                topoSort(v, st, vis, adj);
            }
        }

        st.add(u);
    }
}
