package Leetcode;

import java.util.*;

public class Flood_fill_Algorithm {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }


    public static void main(String[] args) {
        int[][] intArray = {
                {2, 1, 2, 1, 3},
                {2, 3, 3, 3, 2},
                {2, 3, 1, 3, 2},
                {1, 2, 3, 2, 2}
        };

        int[][] ans = floodFill(intArray, 0,0,1);


        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+", ");
            }
            System.out.println();
        }
    }

    // DFS is best, BFS will give TLE error.
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int stColor = image[sr][sc];
        int[][] ans = image;
        // delta row and delta column for neighbours
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, drow, dcol, stColor);
        return ans;

    }

    static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int drow[], int dcol[], int stColor) {
        ans[row][col] = newColor;
        for(int i = 0;i<4;i++) {
            int r = row + drow[i];
            int c = col + dcol[i];
            if(r>=0 && r<image.length && c>=0 && c < image[0].length && image[r][c] == stColor && ans[r][c] != newColor) {
                dfs(r, c, ans, image, newColor, drow, dcol, stColor);
            }
        }
    }
}
