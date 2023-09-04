package Leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Minimum_Spanning_Tree {
    static class Tuple{
        int weight;
        int curNode;
        public Tuple(int weight, int curNode){
            this.weight = weight;
            this.curNode = curNode;
        }
    }

    static class Pair{
        int heapWt;
        int heapNode;
        public Pair(int heapNode, int heapWt){
            this.heapNode = heapNode;
            this.heapWt = heapWt;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1},
        };

        int ans = spanningTree(3,3, matrix);
        System.out.println(ans);
    }

    static int spanningTree(int V, int E, int edges[][]){
        PriorityQueue<Tuple> minHeap = new PriorityQueue<Tuple>((x, y) -> x.weight - y.weight);
        boolean[] vis = new boolean[V];
        int sum = 0;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int n = edges.length;
        int m = edges[0].length;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                adj.get(u).add(new Pair(v, wt));
                adj.get(v).add(new Pair(u, wt));
        }

        minHeap.add(new Tuple(0,0));

        while (!minHeap.isEmpty()){
            Tuple top = minHeap.poll();
            int node = top.curNode;
            int wt = top.weight;
            if (vis[node]) continue;
            vis[node] = true;
            sum += wt;

            for(Pair iter: adj.get(node)){
                int adjNode = iter.heapNode;
                int adjWt = iter.heapWt;
                if (!vis[adjNode]){
                    minHeap.add(new Tuple(adjWt, adjNode));
                }
            }
        }
        return sum;
    }
}
