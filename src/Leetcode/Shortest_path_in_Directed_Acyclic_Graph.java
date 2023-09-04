package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Shortest_path_in_Directed_Acyclic_Graph {
    static class Pair{
        int first;
        int weight;
        public Pair(int first, int weight){
            this.first = first;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2},  {0, 2, 1}};
        int[] ans = shortestPath(4,2, edges);
        System.out.println(Arrays.toString(ans));
    }

    static int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        boolean[] vis = new boolean[N];
        int[] shortestPath = new int[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            shortestPath[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!vis[i]){
                dfs(adj, st, vis, i);
            }
        }

        shortestPath[0] = 0;

        while (!st.isEmpty()){
            int top = st.pop();

            for(Pair it: adj.get(top)){
                int node = it.first;
                int wt = it.weight;
                int totalWt = shortestPath[top] + wt;

                if (totalWt < shortestPath[node]) {
                    shortestPath[node] = totalWt;
                }
            }
        }

        for (int i = 0; i < shortestPath.length; i++) {
            if (shortestPath[i]== Integer.MAX_VALUE) shortestPath[i]= -1;
        }

        return shortestPath;
    }

    private static void dfs(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, boolean[] vis, int node) {
        vis[node] = true;

        for(Pair it: adj.get(node)){
            if (!vis[it.first]){
                dfs(adj, st , vis , it.first);
            }
        }
        st.add(node);
    }
}
