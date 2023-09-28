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
    static List<Integer> parent = new ArrayList<>();
    class DisjointSet {
        static List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        static int findUPar(int node){
            if (node == parent.get(node)){
                return node;
            }

            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        private void unionByRank(int u, int v) {
            int ultp_u = findUPar(u);
            int ultp_v = findUPar(v);

            System.out.println("ultp of " + u + ": " + ultp_u);
            System.out.println("ultp of " + v + ": " + ultp_v);

            if (ultp_u == ultp_v) return;
            if (rank.get(ultp_u) < rank.get(ultp_v)) {
                parent.set(ultp_u, ultp_v);
            } else if (rank.get(ultp_u) > rank.get(ultp_v)) {
                parent.set(ultp_v, ultp_u);
            } else {
                // If dono ka rank is same toh attach v to u.
                parent.set(ultp_v, ultp_u);
                int rankU = rank.get(ultp_u);
                rank.set(ultp_u, rankU+1);
            }
        }
    }
    int numProvinces2(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        int ans=0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && adj.get(j).get(i) == 1){
                    ds.unionByRank(i, j);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            // Can also do this, or access the parent array.
//            if (i == ds.findUPar(i)){
//                ans++;
//            }
            if (i == parent.get(i)){
                ans++;
            }
        }
        return ans;
    }
}