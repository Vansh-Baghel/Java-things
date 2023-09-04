package Leetcode;
import java.util.*;

public class Shortest_Path_in_Undirected_Graph_having_unit_distance {
    static class Pair{
        int first;
        int weight;
        public Pair(int first, int weight){
            this.first = first;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        int[] ans = shortestPath(edges, 9, 10, 0);
    }

    static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[] shortestPath = new int[n];
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            shortestPath[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        q.add(new Pair(src, 0));
        shortestPath[src] = 0;

        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.first;
            int wt = top.weight;

            for(int it: adj.get(node)){
                if(shortestPath[node] + 1 < shortestPath[it]) {
                    q.add(new Pair(it, wt + 1));
                    shortestPath[it] = shortestPath[node] + 1;
                }
            }
        }

        for(int i = 0;i<n;i++) {
            if(shortestPath[i] == 1e9) {
                shortestPath[i] = -1;
            }
        }

        return shortestPath;
    }
}
