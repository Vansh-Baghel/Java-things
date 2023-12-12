package Leetcode;

import java.util.*;

public class Shortest_path_in_Directed_Acyclic_Graph {
    static class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
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
                int node = it.distance;
                int wt = it.node;
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
            if (!vis[it.distance]){
                dfs(adj, st , vis , it.distance);
            }
        }
        st.add(node);
    }
























    public int[] shortestPath2(int N,int M, int[][] edges) {
        //Code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        TreeSet<Pair> treeSet = new TreeSet<>(new Comparator<>() {
            public int compare(Pair a, Pair b) {
                if (a.distance == b.distance)
                    return a.node - b.node;
                return a.distance - b.distance;
            }
        });

        int[] minDist = new int[N];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            list.add(v);
            list.add(dist);
            adj.get(u).add(list);
        }

        treeSet.add(new Pair(0, 0));
        minDist[0] = 0;

        while (!treeSet.isEmpty()){
            Pair top = treeSet.pollFirst();

            int dist = top.distance;
            int node = top.node;

            for (ArrayList<Integer> edge: adj.get(node)){
                int adjNode = edge.get(0);
                int adjDist = edge.get(1);
                int totalDist = adjDist + dist;

                if (totalDist < minDist[adjNode]){
                    minDist[adjNode] = totalDist;
                    treeSet.add(new Pair(totalDist, adjNode));
                }
            }
        }

        for (int i = 0; i < minDist.length; i++) {
            if (minDist[i] == Integer.MAX_VALUE){
                minDist[i] = -1;
            }
        }

        return minDist;
    }
}
