package Leetcode;
import java.util.*;

public class Course_Schedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int V = n;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[V];
        int[] ans = new int[n];
        int ind = 0;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            // We are adding the adj for the second num as its first num because in the question it has been given that for task 0, we have to first complete 1.
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

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
            ans[ind++] = top;

            for(int it: adj.get(top)){
                inorder[it]--;
                if(inorder[it] == 0) q.add(it);
            }
        }

        if (ind == V) return ans;
        int[] arr = {};
        return arr;
    }
}
