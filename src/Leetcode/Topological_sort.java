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
}
