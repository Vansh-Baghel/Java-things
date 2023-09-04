package Leetcode;

import java.util.*;

public class Distance_of_nearest_cell_having_1 {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple{
        Pair pair;
        int count;
        public Tuple(Pair pair, int count){
            this.pair = pair;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[][] binaryGrid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        int[][] ans = nearest(binaryGrid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+", ");
            }
            System.out.println();
        }
    }

    static int[][] nearest(int[][] grid) {
        Queue<Tuple> q = new LinkedList<>();
        int[][] ans = new int[grid.length][grid[0].length];
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    q.add(new Tuple(new Pair(i,j), 0));
                }
            }
        }

        while (!q.isEmpty()){
            int size = q.size();

            for (int o = 0; o < size; o++) {
                checkAll4Directions(grid, vis, q, ans);
            }
        }

        return ans;
    }

    private static void checkAll4Directions(int[][] grid, boolean[][] vis, Queue<Tuple> q, int[][] ans) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        Tuple top = q.poll();
        int row = top.pair.first;
        int col = top.pair.second;
        int count = top.count;

        ans[row][col]=count;

        for (int i = 0; i < 4; i++) {
            int r = row + drow[i];
            int c = col + dcol[i];

            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0 && !vis[r][c]) {
                q.add(new Tuple(new Pair(r,c), count+1));
                vis[r][c] = true;
            }
        }
    }
}
