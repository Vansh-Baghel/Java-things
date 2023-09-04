package Leetcode;

import java.util.*;

public class Find_the_number_of_islands {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };
        int ans = numIslands(grid);
        System.out.println(ans);
    }
    static int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int count= 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    q.add(new Pair(i, j));
                    checkAllDir(q, grid, vis, i, j);
                }
            }
        }

        return count;
    }

    static void checkAllDir(Queue<Pair> q, char[][] grid, boolean[][] vis, int r, int c) {
        int[] drow = {0,1,1,1,0,-1,-1,-1};
        int[] dcol = {1,1,0,-1,-1,0,1,-1};

        while (!q.isEmpty()){
            Pair top = q.poll();
            for (int i = 0; i < drow.length; i++) {
                int row = drow[i] + top.first;
                int col = dcol[i] + top.second;

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && !vis[row][col]){
                    vis[row][col] = true;
                    q.add(new Pair(row, col));
                }
            }
        }
    }
}
