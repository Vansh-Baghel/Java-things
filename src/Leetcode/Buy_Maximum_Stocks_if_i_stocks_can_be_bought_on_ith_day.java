package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Buy_Maximum_Stocks_if_i_stocks_can_be_bought_on_ith_day {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.first, p2.first));
        int res = 0;

        for (int i = 0; i < n; i++) {
            minHeap.add(new Pair(price[i], i + 1));
        }

        while (!minHeap.isEmpty()){
            Pair top = minHeap.poll();
            int m = top.second;
            int curPrice = top.first;

            for (int i = 0; i < m; i++) {
                if (k >= curPrice) {
                    res++;
                    k -= curPrice;
                }
                else break;
            }
        }

        return res;
    }
}
