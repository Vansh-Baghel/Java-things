package Leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Network_Delay_Time {
    static class Pair{
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        TreeSet<Pair> treeSet = new TreeSet<>(new Comparator<>() {
            public int compare(Pair a, Pair b) {
                if (a.distance == b.distance)
                    return a.node - b.node;
                return a.distance - b.distance;
            }
        });
        int[] minDist = new int[n+1];
        int maxi = 0;
        Arrays.fill(minDist, Integer.MAX_VALUE);

        treeSet.add(new Pair(0, k));
        minDist[k] = 0;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int dist = times[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            list.add(v);
            list.add(dist);

            adj.get(u).add(list);
        }

        while (!treeSet.isEmpty()){
            Pair top = treeSet.pollFirst();
            int node = top.node;
            int dist = top.distance;

            for (ArrayList<Integer> edge: adj.get(node)){
                int adjNode = edge.get(0);
                int adjDist = edge.get(1);
                int totalDist = adjDist+dist;

                if (totalDist < minDist[adjNode]){
                    minDist[adjNode] = totalDist;
                    treeSet.add(new Pair(totalDist, adjNode));

                }
            }
        }

        for (int i = 1; i < n; i++) {
            int num = minDist[i];
            if (num == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }
}
