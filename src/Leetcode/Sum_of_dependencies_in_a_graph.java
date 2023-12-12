package Leetcode;

import java.util.*;

public class Sum_of_dependencies_in_a_graph {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int ans = 0;

        for (int i = 0; i < V; i++) {
            ans += adj.get(i).size();
        }

        return ans;
    }
}
