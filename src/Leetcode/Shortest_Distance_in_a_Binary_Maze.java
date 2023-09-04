package Leetcode;
import java.util.*;

public class Shortest_Distance_in_a_Binary_Maze {
    static class Tuple{
        int count;
        int row;
        int col;
        public Tuple(int count, int row, int col){
            this.count = count;
            this.row = row;
            this.col = col;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, source[0], source[1]));
        int n = grid.length;
        int m = grid[0].length;
        int[][] pathCount = new int[grid.length][grid[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pathCount[i][j] = (int)(1e9);
            }
        }

        while (!q.isEmpty()){
            Tuple top = q.poll();
            int row= top.row;
            int col= top.col;
            int count = top.count;

            int[] drow = {-1,1,0,0};
            int[] dcol = {0,0,-1,1};

            for (int i = 0; i < 4; i++) {
                int r = drow[i] + row;
                int c = dcol[i] + col;

                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && pathCount[r][c] > 1 + count){
                    pathCount[r][c] = 1 + count;
                    q.add(new Tuple(count + 1,r,c));
                }
                if (r == destination[0] && c == destination[1]){
                    return count+1;
                }
            }
        }
        return -1;
    }
}
