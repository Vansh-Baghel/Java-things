package Leetcode;
import java.util.*;

public class Shortest_Path_in_Weighted_undirected_graph {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };
        List<Integer> ans = shortestPath2(5, 6, data);
        System.out.println(ans);
    }

    static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] shortestPath = new int[n+1];
        int[] parent = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            shortestPath[i] = (int)(1e9);
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        shortestPath[1] = 0;
        q.add(1);

        while(!q.isEmpty()){
            int top = q.poll();

            for (Pair it: adj.get(top)){
                int node = it.first;
                int wt = it.second;
                int totalwt = shortestPath[top] + wt;

                if (shortestPath[node] > totalwt){
                    shortestPath[node] = totalwt;
                    parent[node] = top;
                    q.add(node);
                }
            }
        }

        if(shortestPath[n] == 1e9) {
            ans.add(-1);
            return ans;
        }

        int idx = n;
        while (parent[idx] != idx){
            ans.add(idx);
            idx = parent[idx];
        }
        ans.add(1);

        Collections.reverse(ans);
        return ans;
    }

    // Dijkstra’s algorithm
    static List<Integer> shortestPath2(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] shortestPath = new int[n+1];
        int[] parent = new int[n+1];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            shortestPath[i] = (int)(1e9);
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        shortestPath[1] = 0;
        minHeap.add(new Pair(0, 1));

        while(!minHeap.isEmpty()){
            Pair node = minHeap.poll();
            // node.second is the node and node.first is the second because this is of minheap. We have used Pair for minheap and adj
            int it = node.second;
            int wt = node.first;

            for(Pair ls: adj.get(it)){
                int adjNode = ls.first;
                int edW = ls.second;
                // shortestPath[node.first] contains the old time in seconds to reach
                int totalWt = edW + wt;

                if (shortestPath[adjNode] > totalWt){
                    shortestPath[adjNode] = totalWt;
                    minHeap.add(new Pair(totalWt, adjNode));
                    parent[adjNode] = it;
                }
            }
        }

        if(shortestPath[n] == 1e9) {
            ans.add(-1);
            return ans;
        }

        int idx = n;
        while (parent[idx] != idx){
            ans.add(idx);
            idx = parent[idx];
        }
        ans.add(1);

        Collections.reverse(ans);
        return ans;
    }
}
