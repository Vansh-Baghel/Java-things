package Leetcode;
import java.util.*;

public class Bipartite_Graph {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 2},
                {0, 1},
                {1, 2}
        };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int[] row : grid) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : row) {
                list.add(num);
            }
            adj.add(list);
        }

        boolean ans = isBipartite(6, adj);
        System.out.println(ans);
    }

    static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] colour = new int[V];

        for (int i = 0; i < V; i++) {
            colour[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if(colour[i] == -1){
                if (!checkColor(V, adj, colour, i)){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkColor(int V, ArrayList<ArrayList<Integer>> adj, int[] colour, int node){
        Queue<Integer> q = new LinkedList<>();
        // Initial color 0.
        q.add(node);
        colour[node] = 0;

        while (!q.isEmpty()){
            int top = q.poll();
            for (int it: adj.get(top)){
                if (colour[it] == -1){
                    colour[it] = colour[top] == 0 ? 1 : 0;
                    q.add(it);
                } else if (colour[it] == colour[top]){
                    return false;
                }
            }
        }
        return true;
    }
















}
