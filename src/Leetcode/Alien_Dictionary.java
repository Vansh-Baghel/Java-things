package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Alien_Dictionary {
    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cada"};
        String ans = findOrder(dict, 5,4);
        System.out.println(ans);
    }
    static String findOrder(String[] dict, int N, int K){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        String ans = "";

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int[] topo = topoSort(K, adj);
        for (int it : topo) {
            ans += (char)(it + (int)('a'));
        }

        return ans;
    }

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
}
