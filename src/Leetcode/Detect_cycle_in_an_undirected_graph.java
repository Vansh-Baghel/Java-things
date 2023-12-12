package Leetcode;
import java.util.*;

public class Detect_cycle_in_an_undirected_graph {
    static class Pair{
        int first;
        int parent;
        public Pair(int first, int parent){
            this.first = first;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();

        edgeList.add(new ArrayList<>(2));
        edgeList.get(0).add(0, 0);
        edgeList.get(0).add(1, 1);

        edgeList.add(new ArrayList<>(2));
        edgeList.get(1).add(0, 1);
        edgeList.get(1).add(1, 2);

        edgeList.add(new ArrayList<>(2));
        edgeList.get(2).add(0, 1);
        edgeList.get(2).add(1, 3);

        edgeList.add(new ArrayList<>(2));
        edgeList.get(3).add(0, 2);
        edgeList.get(3).add(1, 4);

        edgeList.add(new ArrayList<>(2));
        edgeList.get(4).add(0, 3);
        edgeList.get(4).add(1, 4);

        edgeList.add(new ArrayList<>(2));
        edgeList.get(5).add(0, 4);
        edgeList.get(5).add(1, 5);

        System.out.println(isCycle(10, edgeList));
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if (detectCycle(V, adj, vis, i)){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        vis[i] = true;

        while (!q.isEmpty()){
            Pair top = q.poll();

            for (int it: adj.get(top.first)){
                if (!vis[it]){
                    q.add(new Pair(it, top.first));
                    vis[it] = true;
                } else if(top.parent != it){
                    return true;
                }
            }
        }
        return false;
    }














    public boolean isCycle2(int V, ArrayList<ArrayList<Integer>> adj) {
         boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleDFS(i, adj, vis, -1)){
                return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[u] = true;

        for (int v: adj.get(u)){
            if (vis[v]){
                if(parent != v) return true;
            } else if (isCycleDFS(v, adj, vis, u)) return true;
        }

        return false;
    }


    public boolean isCycle3(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
        if (!vis[i] && isCycleBFS(i, vis, adj)){
            return true;
        }
    }

        return false;
}

    private boolean isCycleBFS(int u, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(u, -1));
        vis[u] = true;

        while (!q.isEmpty()){
            Pair top = q.poll();
            int node = top.first;
            int par = top.parent;

            for (int v: adj.get(node)){
                if (!vis[v]){
                    vis[v] = true;
                    q.add(new Pair(v, node));
                } else if (par != v) return true;
            }
        }

        return false;
    }
}
