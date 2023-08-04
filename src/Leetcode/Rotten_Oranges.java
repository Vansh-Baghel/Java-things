package Leetcode;

import java.util.*;
// Creating Queue
import java.util.*;
class Rotten_Oranges {
    public static void main(String[] args) {
        int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};

        Rotten_Oranges obj = new Rotten_Oranges();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }

    //Function to find minimum time required to rot all oranges.
    static int orangesRotting(int[][] grid) {

        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if (grid[i][j] == 2){
                    rottenTheOranges(i , j, grid , count, vis);
                }
            }
        }
        return count;
    }

    static void rottenTheOranges(int row, int col, int[][] grid, int count, int[][] vis){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        // In case there is no fresh orange available.
        if (grid[row][col] == 1) {
            vis[row][col] = 1;
            grid[row][col] = 2;
            count++;
        }

        rottenTheOranges(row + 1, col, grid , count , vis);
        rottenTheOranges(row, col + 1, grid , count , vis);
        rottenTheOranges(row - 1, col, grid , count , vis);
        rottenTheOranges(row + 1, col - 1, grid , count , vis);
        return;
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
}
