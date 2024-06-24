package Leetcode;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {
    static class Tuple{
        int curStep;
        int node;
        int price;
        public Tuple(int curStep, int node, int price){
            this.curStep = curStep;
            this.node = node;
            this.price = price;
        }
    }

    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
//        int[][] flights = {
//                {0, 1, 1},
//                {0, 2, 5},
//                {1, 2, 1},
//                {2, 3, 1}
//        };

        int[][] flights = {
                {0, 1, 5},
                {1, 2, 5},
                {0, 3, 2},
                {3, 1, 2},
                {1, 4, 1},
                {4, 2, 1}
        };

        int src = 0;
        int dst = 2;
        int k = 2;

        int result = findCheapestPrice2(flights.length, flights, src, dst, k);
        System.out.println(result);
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];

                if (!adj.containsKey(node)) continue;

                for (int[] next : adj.get(node)) {
                    int neighbour = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] {neighbour, dist[neighbour]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }


    // TLE
    public static int res = Integer.MAX_VALUE;

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights){
            int u = flight[0], v = flight[1], price = flight[2];
            adj.get(u).add(new Pair(v, price));
        }

        dfs(src, dst, k, adj, 0);

        int tmp = res;
        res = Integer.MAX_VALUE;

        return tmp == Integer.MAX_VALUE ? -1 : tmp;
    }

    public static void dfs(int src, int des, int k, List<List<Pair>> adj, int curSum){
        for (Pair it: adj.get(src)){
            int v = it.first, wt = it.second;
            curSum += wt;
            k--;

            if (k < -1) return;

            if (v == des) {
                res = Math.min(curSum, res);
                curSum -= wt;
                k++;
                continue;
            }

            dfs(v, des, k, adj, curSum);
            curSum -= wt;
            k++;
        }
    }
}
