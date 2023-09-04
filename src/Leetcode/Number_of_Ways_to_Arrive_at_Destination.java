package Leetcode;
import java.util.*;

public class Number_of_Ways_to_Arrive_at_Destination {
        static class Pair {
            int nodeWeight;
            int node;

            Pair(int nodeWeight, int node) {
                this.nodeWeight = nodeWeight;
                this.node = node;
            }
        }

        static class adjPair {
            int first;
            int weight;

            adjPair(int first, int weight) {
                this.first = first;
                this.weight = weight;
            }
        }

        static int countPaths(int n, List<List<Integer>> roads) {
            List<List<adjPair>> adj = new ArrayList<>();
            int m = roads.size();
            long[] shortestPath = new long[n];
            int mod = (int) (1e9 + 7);

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
                shortestPath[i] = Long.MAX_VALUE;
            }

            for (int i = 0; i < m; i++) {
                int u = roads.get(i).get(0);
                int v = roads.get(i).get(1);
                int wt = roads.get(i).get(2);

                adj.get(u).add(new adjPair(v, wt));
                adj.get(v).add(new adjPair(u, wt));
            }

            long[] ways = new long[n];
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.nodeWeight - y.nodeWeight);

            pq.add(new Pair(0, 0));
            shortestPath[0] = 0;
            ways[0] = 1;

            while (!pq.isEmpty()) {
                Pair top = pq.poll();
                int nodeWeight = top.nodeWeight;
                int node = top.node;

                for (adjPair iter : adj.get(node)) {
                    int adjNode = iter.first;
                    int adjWt = iter.weight;
                    long totalWt = (long) nodeWeight + adjWt;

                    if (shortestPath[adjNode] > totalWt) {
                        shortestPath[adjNode] = totalWt;
                        pq.add(new Pair((int) totalWt, adjNode));
                        ways[adjNode] = ways[node] % mod;
                    } else if (shortestPath[adjNode] == totalWt) {
                        ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                    }
                }
            }

            return (int) (ways[n - 1] % mod);
        }
}
