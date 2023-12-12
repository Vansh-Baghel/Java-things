package Leetcode;

import java.util.*;

public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    static class Pair{
        int first;
        int sec;

        public Pair(int first, int sec){
            this.first=first;
            this.sec=sec;
        }
    }

    private int minimumReorder= 0;

    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] connection: connections){
            int u = connection[0];
            int v = connection[1];

            adj.get(u).add(new Pair(v,1));
            adj.get(v).add(new Pair(u,0));
        }

        dfs(0, -1, adj);

        return minimumReorder;
    }

    private void dfs(int u, int parent, List<List<Pair>> adj) {
        for(Pair top: adj.get(u)) {
            int v = top.first;
            int isOriginal = top.sec;

            if (v != parent) {
                if (isOriginal == 1) {
                    minimumReorder++;
                }
                dfs(v, u, adj);
            }
        }
    }
}
