package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Min_Cost_to_Connect_All_Points {
    static class Pair{
        int heapWt;
        int heapNode;
        public Pair(int heapWt, int heapNode){
            this.heapWt = heapWt;
            this.heapNode = heapNode;
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

    public class Disjoint_2{
        int[] rank;
        int[] parent;
        public Disjoint_2(int n) {
            this.rank = new int[n];
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int findParent(int i){
            if (parent[i] == i) return i;

            return parent[i] = findParent(parent[i]);
        }

        public void unionByRank(int u, int v){
            int par_u = findParent(u);
            int par_v = findParent(v);

            if (par_v != par_u){
                if (rank[par_u] == rank[par_v]){
                    parent[par_v] = par_u;
                    rank[par_u]++;
                }
                else if (rank[par_u] > rank[par_v]) parent[par_v] = par_u;
                else parent[par_u] = par_v;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int ans = minCostConnectPoints(matrix);
        System.out.println(ans);
    }

    static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y)-> x.heapWt - y.heapWt);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int n = points.length, sum=0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int parFirst = points[i][0];
                int parSec = points[i][1];
                int curFirst = points[j][0];
                int curSec = points[j][1];
                int wt = Math.abs(parFirst - curFirst) + Math.abs(parSec - curSec);

                adj.get(i).add(new Pair(wt, j));
                adj.get(j).add(new Pair(wt, i));
            }
        }

        minHeap.add(new Pair(0,0));

        while (!minHeap.isEmpty()){
            Pair top = minHeap.poll();

            int heapWt = top.heapWt;
            int heapNode = top.heapNode;

            if (vis[heapNode]) continue;
            vis[heapNode] = true;
            sum+=heapWt;

            for (Pair v: adj.get(heapNode)){
                int wt = v.heapWt;
                int node = v.heapNode;

                if (!vis[node]) {
                    minHeap.add(new Pair(wt, node));
                }
            }
        }

        return sum;
    }

    public int minCostConnectPoints2(int[][] points) {
        int n = points.length, sum=0;
        List<Edge> edgeList = new ArrayList<>();
        Disjoint_2 ds = new Disjoint_2(n);

        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int parFirst = points[u][0];
                int parSec = points[u][1];
                int curFirst = points[v][0];
                int curSec = points[v][1];
                int wt = Math.abs(parFirst - curFirst) + Math.abs(parSec - curSec);

                edgeList.add(new Edge(u,v,wt));
                edgeList.add(new Edge(v,u,wt));
            }
        }

        Collections.sort(edgeList);

        for (Edge edge: edgeList){
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;

            if (ds.findParent(u) != ds.findParent(v)){
                ds.unionByRank(u,v);
                sum+=wt;
            }
        }

        return sum;
    }
}
