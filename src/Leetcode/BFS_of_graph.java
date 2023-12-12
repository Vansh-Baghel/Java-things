package Leetcode;
import java.util.*;

public class BFS_of_graph {
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
        innerList1.add(2);
        innerList1.add(3);

        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(0);

       ArrayList<Integer> innerList3 = new ArrayList<>();
        innerList3.add(0);
        innerList3.add(4);

        ArrayList<Integer> innerList4 = new ArrayList<>();
        innerList4.add(0);

        ArrayList<Integer> innerList5 = new ArrayList<>();
        innerList5.add(2);

        // Add the inner lists to the outer list
        adj.add(innerList1);
        adj.add(innerList2);
        adj.add(innerList3);
        adj.add(innerList4);
        adj.add(innerList5);

        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        System.out.println(ans);
    }

    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        int node = 0;
        q.add(node);
        vis[0] = true;
        ans.add(node);

        while (!q.isEmpty()){
            node = q.poll();

            for(int it: adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                    ans.add(it);
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> bfsOfGraph2(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;
        ans.add(0);

        while (!q.isEmpty()){
            int u = q.poll();

            for (int v: adj.get(u)){
                if (!vis[v]){
                    vis[v] = true;
                    q.add(v);
                    ans.add(v);
                }
            }
        }
        return ans;
    }
}
