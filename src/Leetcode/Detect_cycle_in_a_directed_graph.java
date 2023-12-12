package Leetcode;
import java.util.*;

public class Detect_cycle_in_a_directed_graph {
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

        boolean ans = isCyclic(6, adj);
        System.out.println(ans);
    }

    // Using DFS
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(adj, i, vis, pathVis)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] pathVis) {
        pathVis[node] = true;
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (detectCycle(adj, it, vis, pathVis)) return true;
            }
            // means both vis and pathVis is true.
            else if (pathVis[it]) return true;

        }

        // this condition will run when there are no adj left.
        pathVis[node] = false;
        return false;
    }

    // Using BFS, Kahn's Algo
    static boolean isCyclic2(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[V];
        int ind = 0;
        int count = 0;

        for (int i = 0; i < V; i++) {
            for(int it: adj.get(i)){
                inorder[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inorder[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int top = q.poll();
            count++;

            for(int it: adj.get(top)){
                inorder[it]--;
                if(inorder[it] == 0) q.add(it);
            }
        }

        if (count != V) return true;
        return false;
    }


    static boolean isCyclic3(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleDFS(i, vis, inRecursion, adj)){
                return true;
            }
        }

        return false;
    }

    static boolean isCycleDFS(int u, boolean[] vis, boolean[] inRecursion, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = true;
        inRecursion[u]=true;

        for (int v: adj.get(u)){
            if (!vis[v] && isCycleDFS(v, vis, inRecursion,adj)){
                return true;
            } else if (inRecursion[v]) return true;
        }

        inRecursion[u]=false;
        return false;
    }


    public boolean isCyclic4(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        int size = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            for (int it: adj.get(i)){
                indegree[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int u = q.poll();
            size++;

            for (int v: adj.get(u)){
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return size != V;
    }
}