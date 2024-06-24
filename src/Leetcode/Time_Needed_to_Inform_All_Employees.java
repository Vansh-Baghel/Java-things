package Leetcode;

import java.util.*;

public class Time_Needed_to_Inform_All_Employees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) adj.get(manager[i]).add(i);
        }

        return dfs(adj, informTime, headID);
    }

    public int dfs(List<List<Integer>> adj, int[] informTime, int node){
        int maxi = 0;

        for (int v: adj.get(node)){
            maxi = Math.max(dfs(adj, informTime, v), maxi);
        }

        return maxi + informTime[node];
    }
}
