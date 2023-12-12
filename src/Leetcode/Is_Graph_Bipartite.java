package Leetcode;

import java.util.*;

public class Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int num: graph[i]){
                adj.get(i).add(num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                q.add(i);
                color[i] = 0;
                if (!bfs(q, color, adj)) return false;
            }
        }

        return true;
    }

    private boolean bfs(Queue<Integer> q, int[] color, List<List<Integer>> adj) {
        while (!q.isEmpty()){
            int node = q.poll();

            for (int v: adj.get(node)){
                if (color[v] == -1){
                    color[v] = 1 - color[node];
                    q.add(v);
                } else if (color[node] == color[v]) return false;
            }
        }

        return true;
    }


    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int num: graph[i]){
                adj.get(i).add(num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                color[i] = 0;
                if (!dfs(i, color, adj)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int u, int[] color, List<List<Integer>> adj) {
        for (int v: adj.get(u)){
            if (color[v] == -1){
                color[v] = 1 - color[u];
                if (!dfs(v, color, adj)) return false;
            } else if (color[v] == color[u]) return false;
        }

        return true;
    }

    public boolean isBipartite3(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int num: graph[i]){
                adj.get(i).add(num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                if (!dfs2(i, color, adj, 0)) return false;
            }
        }

        return true;
    }

    private boolean dfs2(int u, int[] color, List<List<Integer>> adj, int curColor) {
        color[u] = curColor;

        for (int v : adj.get(u)) {
            if (color[v] == -1) {
                int colorOfV = 1 - curColor;
                if (!dfs2(v, color, adj, colorOfV)) return false;
            } else if (color[v] == color[u]) return false;
        }

        return true;
    }
}
