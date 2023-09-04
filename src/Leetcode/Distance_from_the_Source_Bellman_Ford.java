package Leetcode;
import java.util.*;

public class Distance_from_the_Source_Bellman_Ford {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] shortestPath = new int[V];

        for (int i = 0; i < V; i++) shortestPath[i] = (int) 1e8;

        shortestPath[S] = 0;

        // V - 1 is taken because at max we will require V - 1 iterations if the graph contains positive or negative weights. If we do the iteration Vth time, and if the shortestPath again changes, then we could say that there exists a negative weighted cycle. Everytime we go through this cycle, the weight gets reduced.
        for (int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> it: edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                int totalWt = wt + shortestPath[u];

                if (shortestPath[u] != 1e8 && shortestPath[v] > totalWt){
                    shortestPath[v] = totalWt;
                }
            }
        }

        // Since we have to return -1 if the negative weight exists, we will run this loop, which is the Vth loop.
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            int totalWt = wt + shortestPath[u];

            // If it satisies this condition, means there exists a negative num. Therefore return -1 in such case.
            if (shortestPath[u] != 1e8 && shortestPath[v] > totalWt){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return shortestPath;
    }
}
