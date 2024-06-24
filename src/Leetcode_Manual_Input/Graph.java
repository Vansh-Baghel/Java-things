package Leetcode_Manual_Input;

import java.util.*;

public class Graph {
        public static void main(String[] args) {

            // Create the graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int[][] edges = {{2, 2}};
            int n = edges.length;

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            printGraph(adj);
        }

        // Print the graph
        static void printGraph(ArrayList<ArrayList<Integer>> adj) {
            for (int i = 0; i < adj.size(); i++) {
                System.out.println("\nVertex " + i + ":");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(" -> " + adj.get(i).get(j));
                }
                System.out.println();
            }
        }
}
