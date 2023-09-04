package Leetcode;

import java.util.*;
// Creating Queue
import java.util.*;
class Rotten_Oranges {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] grid =  {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        Rotten_Oranges obj = new Rotten_Oranges();
        int ans = orangesRotting(grid);
        System.out.println(ans);
    }

//    Other Method
//int n = grid.length;
//    int m = grid[0].length;
//    Queue<Pair> q= new LinkedList<>();
//    int cntFresh = 0;
//    int cntFreshConvertedtoRotten = 0;
//    int tm = 0;
//
//    int[][] vis = new int[n][m];
//
//        for (int i = 0 ; i < n ; i++){
//        for (int j = 0 ; j < m ; j++){
//            if (grid[i][j] == 2){
//                q.add(new Pair(i, j, 0));
//                vis[i][j] = 2;
//            }
//            if (grid[i][j] == 1) cntFresh++;
//        }
//    }
//
//    int[] drow = {-1, 0 , 1, 0};
//    int[] dcol = {0 , -1 , 0, 1};
//
//        while (!q.isEmpty()){
//        int nrow = q.peek().row;
//        int ncol = q.peek().col;
//        int t = q.peek().tm;
//        tm = Math.max(tm , t);
//        q.remove();
//
//        for (int i = 0 ; i < 4 ; i++){
//            int r = nrow + drow[i];
//            int c = ncol + dcol[i];
//
//            if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 0 && grid[r][c] == 1){
//                vis[r][c] = 2;
//                q.add(new Pair(r, c, t + 1));
//                cntFreshConvertedtoRotten++;
//            }
//        }
//    }
//        if (cntFresh != cntFreshConvertedtoRotten) return -1;
//        else return tm;

    static int orangesRotting(int[][] grid){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = -1;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                vis[cur.first][cur.second] = true;

                for (int d = 0; d < 4; d++) {
                    int r = cur.first + drow[d];
                    int c = cur.second + dcol[d];

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !vis[r][c]) {
                        grid[r][c] = 2;
                        q.add(new Pair(r, c));
                        freshOranges--;
                    }
                }
            }
            count++;
        }
            return freshOranges > 0 ? -1: count;
        }
    }
