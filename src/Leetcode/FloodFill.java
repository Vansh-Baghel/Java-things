package Leetcode;

import java.util.*;

class Solutions
{
    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // sr = 1, sc = 1, newColor = 2
        Solutions obj = new Solutions();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        int m = image.length;
        int n = image[0].length;
        int[][] vis = new int[m][n];

        vis[sr][sc]= newColor;

        int initialValue = image[sr][sc];

        floodRecursion(image, sr,sc,newColor, vis, initialValue);
        return image;
    }

    static void floodRecursion(int[][] image, int row, int col, int newColor, int[][] vis, int initialValue){
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;

        if (image[row][col] != initialValue || vis[row][col] == initialValue) return;

        image[row][col] = newColor;
        vis[row][col] = newColor;

        floodRecursion(image, row + 1 , col, newColor, vis, initialValue );
        floodRecursion(image, row - 1, col, newColor, vis, initialValue);
        floodRecursion(image, row , col + 1 , newColor, vis, initialValue);
        floodRecursion(image, row , col - 1, newColor, vis, initialValue);
        return;
    }
}