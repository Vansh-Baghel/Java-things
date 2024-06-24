package Leetcode;

import java.util.*;

public class City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };

        System.out.println(findCity(n,m,edges,4));
    }

    static int findCity(int n, int m, int[][] edges,int distanceThreshold){
        //code here
        int mini = Integer.MAX_VALUE, res = 0;
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] edge: edges){
            mat[edge[0]][edge[1]] = edge[2];
            mat[edge[1]][edge[0]] = edge[2];
        }

        for (int via = 0; via < n; via++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (mat[i][via] == Integer.MAX_VALUE || mat[via][j] == Integer.MAX_VALUE) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++){
            int curCnt = 0;
            for (int j = 0; j < n; j++){
                if (distanceThreshold >= mat[i][j] && i != j){
                    curCnt++;
                }
            }

            if (mini >= curCnt){
                mini = curCnt;
                res = i;
            }
        }

        return res;
    }
}
