package Leetcode;

import java.util.*;

public class Shortest_Path_in_Binary_Matrix {
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
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    static int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int pathCount = 0, n = grid.length;

        if (grid[0][0] == 1) return -1;

        q.add(new Pair(0,0));
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Pair top = q.poll();

                int r = top.row;
                int c = top.col;

                if (r == n - 1 && c == n - 1) return pathCount + 1;

                int[] drow = {-1,-1,-1,0,0,1,1,1};
                int[] dcol = {-1,0,1,-1,1,-1,0,1};

                for (int i = 0; i < 8; i++) {
                    int row = r + drow[i];
                    int col = c + dcol[i];

                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0){
                        grid[row][col] = 1;
                        q.add(new Pair(row, col));
                    }
                }
            }
            pathCount++;
        }
        return -1;
    }

    public int shortestPathBinaryMatrix2(int[][] grid) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<Tuple>((x, y) -> x.dist - y.dist);
        int pathCount = 0, n = grid.length;
        int[][] minDist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        if (grid[0][0] == 1) return -1;

        minHeap.add(new Tuple(0, new Pair(0,0)));
        grid[0][0] = 1;

        while(!minHeap.isEmpty()){
            int size = minHeap.size();

            for (int j = 0; j < size; j++) {
                Tuple top = minHeap.poll();

                int dist = top.dist;
                int r = top.pair.row;
                int c = top.pair.col;

                if (r == n - 1 && c == n - 1) return pathCount + 1;

                int[] drow = {-1,-1,-1,0,0,1,1,1};
                int[] dcol = {-1,0,1,-1,1,-1,0,1};

                for (int i = 0; i < 8; i++) {
                    int row = r + drow[i];
                    int col = c + dcol[i];

                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0){
                        grid[row][col] = 1;
                        int totalDist = dist + 1;

                        if (totalDist < minDist[row][col]){
                            minDist[row][col] = totalDist;
                            minHeap.add(new Tuple(totalDist, new Pair(row, col)));
                        }
                    }
                }
            }
            pathCount++;
        }
        return -1;
    }
}
