package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Find_all_Critical_Connections_in_the_Graph {
    static int timer = 1;

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int v = 3; // Number of vertices

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);

        System.out.println(criticalConnections(3, adj));
    }

    static ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj){
        // Code here
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        boolean[] vis = new boolean[v];
        // tin => time of interaction, low => will store the lowest value from the path it came from.
        int[] tin = new int[v], low = new int[v];

        // Intitution is to store the time taken to reach each node, and will store the lowest time
        // taken by any adjacent node, and while backtracking will check if the child node ka lowest is
        // greater than the parent node ka interaction, if it is means child is not related to previous nodes
        // of parent, therefore 2 different graphs can be broken, and due to which we will find the bridge.
        dfs(0, -1, vis, tin, low, adj, bridges);

        Collections.sort(bridges, ((x, y) -> {
            if (Objects.equals(x.get(0), y.get(0))) return x.get(1) - y.get(1);
            return x.get(0) - y.get(0);
        }));

        return bridges;
    }

    static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> bridges){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for (int it: adj.get(node)){
            if (it == parent) continue;
            if (!vis[it]){
                dfs(it, node, vis, tin, low, adj, bridges);

                low[node] = Math.min(low[node], low[it]);
                // If child ka lowest is greater than parent ka reach time, then bridge possible
                if (low[it] > tin[node]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(Math.min(it, node));
                    list.add(Math.max(it, node));
                    bridges.add(new ArrayList<>(list));
                }
            } else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}
