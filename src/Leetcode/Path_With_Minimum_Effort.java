package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Path_With_Minimum_Effort {
    static class Tuple {
        int dist;
        Pair pair;

        public Tuple(int dist, Pair pair) {
            this.dist = dist;
            this.pair = pair;
        }
    }

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 10, 6, 7, 9, 10, 4, 9}};
        System.out.println(minimumEffortPath(array));
    }

    static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<Tuple>((x, y) -> x.dist - y.dist);
        int n = heights.length, m = heights[0].length;
        int[][] minDist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        minHeap.add(new Tuple(0, new Pair(0,0)));
        minDist[0][0] = 0;

        while(!minHeap.isEmpty()){
            Tuple top = minHeap.poll();

            int dist = top.dist;
            int r = top.pair.row;
            int c = top.pair.col;

            int[] drow = {-1,1,0,0};
            int[] dcol = {0,0,1,-1};

            if (r == n -1 && c == m - 1) {
                return dist;
            }

            for (int i = 0; i < drow.length; i++) {
                int row = r + drow[i];
                int col = c + dcol[i];

                if (row >= 0 && row < n && col >= 0 && col < m){
                    int totalDist = Math.max(dist, Math.abs(heights[row][col] - heights[r][c]));

                    if (totalDist < minDist[row][col]){
                        minDist[row][col] = totalDist;
                        minHeap.add(new Tuple(totalDist, new Pair(row, col)));
                    }
                }
            }
        }
        return minDist[n-1][m-1];
    }
}
