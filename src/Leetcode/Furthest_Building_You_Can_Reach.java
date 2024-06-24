package Leetcode;

import java.util.*;

public class Furthest_Building_You_Can_Reach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return solve(0, heights.length, bricks, ladders, heights);
    }

    public int solve(int idx, int n, int b, int l, int[] h){
        if (idx == n - 1) return 0;

        if (h[idx+1] < h[idx]) return 1 + solve(idx + 1, n, b, l, h);
        else {
            int pickBricks = 0, pickLadder = 0;
            if (b >= h[idx+1] - h[idx]) pickBricks = 1 + solve(idx + 1, n, b - (h[idx+1] - h[idx]), l, h);
            if (l > 0) pickLadder = 1 + solve(idx + 1, n, b, l - 1, h);
            return Math.max(pickBricks, pickLadder);
        }
    }

    public int furthestBuilding2(int[] heights, int bricks, int ladder) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = heights.length;

        for(int i = 0; i < n - 1; i++){
            if (heights[i] >= heights[i + 1]) continue;

            int dif = heights[i + 1] - heights[i];

            if (bricks >= dif) {
                bricks -= dif;
                pq.add(dif);
            } else if (ladder > 0) {
                if (!pq.isEmpty()){
                    int top = pq.peek();
                    // If pehle used difference is greater than current wala, toh get the bricks, and use ladder.
                    if (top > dif) {
                        pq.poll();
                        bricks+=top;
                        bricks-=dif;
                        pq.add(dif);
                    }
                }
                // Writing this here, because if pq is empty, and bricks is smaller than difference, even then we will use ladder.
                ladder--;
            } else {
                // Both ladder and bricks se nhi reach hora then just break;
                return i;
            }
        }

        return n - 1;
    }
}
