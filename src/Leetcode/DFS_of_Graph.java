package Leetcode;
import java.util.*;

public class DFS_of_Graph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(0);
        dfs(0, adj, vis, ans);
        return ans;
    }

    private void dfs(int index, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        int node = index;
        vis[node] = true;


        for(int it: adj.get(node)){
            if(!vis[it]){
                node=it;
                ans.add(node);
                dfs(node, adj, vis, ans);
            }
        }
    }








    ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> dfsOfGraph2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs2(adj, vis, i);
            }
        }
        return ans;
    }

    private void dfs2(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int u) {
        vis[u]=true;
        ans.add(u);

        for (int v: adj.get(u)){
            if (!vis[v]){
                dfs2(adj, vis, v);
            }
        }
    }
}
