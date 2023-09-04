package Leetcode;
import java.util.*;

public class Number_of_Provinces {
    static class Node {
        int data;
        Largest_BST.Node left;
        Largest_BST.Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        innerList1.add(0);

        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(0);
        innerList2.add(1);

        // Add the inner lists to the outer list
        adj.add(innerList1);
        adj.add(innerList2);

        int ans = numProvinces(adj, 2);
        System.out.println(ans);
    }

    // Converted to new list method
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();

        // Adding new nodes into the list.
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // Converting the matrix into list.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for(int it: adj.get(node)){
            if(!vis[it]){
                node=it;
                dfs(node, adj, vis);
            }
        }
    }

    // For without converting to list, directly from matrix, we need to use a vis with the length of matrix, and visit each of the vis node and adj node to check if its visited or not, this will cause more time and space since we will move through 2 matrices, and will also need a space of whole matrix.

}

