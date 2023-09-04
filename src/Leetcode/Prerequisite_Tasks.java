package Leetcode;
import java.util.*;

public class Prerequisite_Tasks {
    public boolean isPossible(int N,int P, int[][] prerequisites){
        int V = N;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        int count = 0;
        int ind = 0;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it: prerequisites){
            adj.get(it[0]).add(it[1]);
        }

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
            count++;

            for(int it: adj.get(top)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        return count != V ? false : true;
    }
}
