package Leetcode;

import java.util.PriorityQueue;

public class Total_Cost_to_Hire_K_Workers {
    public static void main(String[] args) {
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3;
        int candidates = 4;

        System.out.println(totalCost(costs,k,candidates));
    }

    static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>((x, y) -> x - y);
        int n = costs.length, s = 0, e = n - 1;
        int cnt = 0;
        long ans = 0;

        while (cnt < k){
            while (minHeap1.size() != candidates && s <= e){
                minHeap1.add(costs[s++]);
            }
            while (minHeap2.size() != candidates && e >= s){
                minHeap2.add(costs[e--]);
            }

            int n1 = minHeap1.isEmpty() ? Integer.MAX_VALUE : minHeap1.peek();
            int n2 = minHeap2.isEmpty() ? Integer.MAX_VALUE : minHeap2.peek();

            if (n1 <= n2){
                ans += n1;
                minHeap1.poll();
            } else {
                ans += n2;
                minHeap2.poll();
            }
            cnt++;
        }

        return ans;
    }
}
