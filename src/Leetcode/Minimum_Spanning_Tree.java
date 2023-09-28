package Leetcode;

import java.util.*;

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



    // Disjoint set method
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int _src, int _dest, int _wt) {
            this.src = _src;
            this.dest = _dest;
            this.weight = _wt;
        }

        public int compareTo(Edge p2) {
            return this.weight - p2.weight;
        }
    }

    static int spanningTree2(int V, int E, int edges[][]){
            List<Edge> edgeList = new ArrayList<Edge>();

            for (int i = 0; i < E; i++) {
                int src = edges[i][0];
                int dest = edges[i][1];
                int weight = edges[i][2];
                Edge temp = new Edge(src, dest, weight);
                edgeList.add(temp);
            }

            DisjointSet ds = new DisjointSet(V);
            Collections.sort(edgeList);
            int ans = 0;

            for (int i = 0; i < edgeList.size(); i++) {
                int wt = edgeList.get(i).weight;
                int u = edgeList.get(i).src;
                int v = edgeList.get(i).dest;
                if (ds.findUPar(u) != ds.findUPar(v)) {
                    ans += wt;
                    ds.unionBySize(u, v);
                }
            }
            return ans;
        }
}