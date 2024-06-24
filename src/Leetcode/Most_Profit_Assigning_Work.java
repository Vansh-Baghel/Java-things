package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Most_Profit_Assigning_Work {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int res = 0;

        for (int i = 0; i < profit.length; i++) {
            pq.offer(new int[]{profit[i], difficulty[i]});
        }
        Arrays.sort(worker);

        int i = worker.length - 1;

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            while (i >= 0 && worker[i] >= top[1]) {
                res += top[0];
                i--;
            }
        }

        return res;
    }
}
