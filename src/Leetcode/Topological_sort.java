package Leetcode;
import java.util.*;

public class Topological_sort {

    // Using DFS
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        boolean[] vis = new boolean[V];
        int[] ans = new int[V];
        Stack<Integer> st = new Stack<>();
        int j = 0;

        for(int i = 0; i < V; i++){
            if (!vis[i]) {
                dfs(adj, i, st, vis);
            }
        }

        while (!st.isEmpty()){
            ans[j++] = st.pop();
        }

        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean[] vis) {
        vis[node] = true;

        for(int it: adj.get(node)){
            if (!vis[it]){
                dfs(adj, it, st, vis);
            }
        }

        st.add(node);
    }

    // Using BFS, Kahn's Algo
    static int[] topoSort2(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        int[] ans = new int[V];
        int ind = 0;

        for (int i = 0; i < V; i++) {
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int top = q.poll();
            ans[ind++] = top;

            for(int it: adj.get(top)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
         return ans;
    }

    static int[] topoSort3(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                topoDFS(i, adj, vis, st);
            }
        }

        int size = st.size();
        for (int i = 0; i < size; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }

    private static void topoDFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;

        for(int v: adj.get(u)){
            if (!vis[v]){
                topoDFS(v,adj,vis,st);
            }
        }
        st.add(u);
    }

    static int[] topoSort4(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] degree = new int[V];
        int[] ans = new int[V];
        int k = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < adj.size(); i++) {
           for(int it: adj.get(i)) degree[it]++;
        }

        for (int i = 0; i < V; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()){
            int u = q.poll();
            ans[k++] = u;

            for (int v: adj.get(u)){
                degree[v]--;
                if (degree[v] == 0) q.add(v);
            }
        }

        return ans;
    }
}
