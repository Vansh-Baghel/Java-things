package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        int n = 3;
        int[][] flights = {{0, 1, 2}, {1, 2, 1}, {2, 0, 10}};
        int src = 1;
        int dst = 2;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);

    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            price[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int pr = flights[i][2];

            adj.get(u).add(new Pair(v, pr));
        }

        q.add(new Tuple(0, src, 0));

        while (!q.isEmpty()){
            Tuple top = q.poll();
            int curStep = top.curStep;
            int topPrice = top.price;
            int node = top.node;

            if (curStep == k + 1 && node == dst) return topPrice;

            for (Pair it: adj.get(node)){
                int totalPr = it.second + topPrice;

                if (totalPr < price[it.first]){
                    q.add(new Tuple(curStep + 1, it.first, totalPr));
                    price[it.first] = totalPr;
                }
            }
        }
        if(price[dst] == (int)(1e9)) return -1;
        return price[dst];
    }
}
