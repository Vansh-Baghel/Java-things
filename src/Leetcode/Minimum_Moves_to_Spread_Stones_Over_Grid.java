package Leetcode;

import java.util.*;

public class Minimum_Moves_to_Spread_Stones_Over_Grid {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 0},
                {0, 1, 0},
                {0, 3, 0}
        };

        System.out.println(minimumMoves(grid));
    }

    static class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int minimumMoves(int[][] grid) {
        List<Pair> zeros = new ArrayList<>(), extras = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (grid[i][j] == 0) zeros.add(new Pair(i,j));
                else if (grid[i][j] > 1) extras.add(new Pair(i,j));
            }
        }

        return solve(zeros, extras, grid, 0);
    }

    private static int solve(List<Pair> zeros, List<Pair> extras, int[][] grid, int curIdx) {
        if (curIdx == zeros.size()) return 0;

        int mini = 1000000;

        int curZerRow = zeros.get(curIdx).r, curZerCol = zeros.get(curIdx).c;

        for (int i = 0; i < extras.size(); i++) {
            int curExtraRow = extras.get(i).r, curExtraCol = extras.get(i).c;

            if (grid[curExtraRow][curExtraCol] > 1) {
                grid[curExtraRow][curExtraCol]--;
                grid[curZerRow][curZerCol] = 1;

                mini = Math.min(mini, manhattan(curZerRow, curZerCol, curExtraRow, curExtraCol) + solve(zeros, extras, grid, curIdx + 1));

                // Backtracking and making the blocks as before
                grid[curExtraRow][curExtraCol]++;
                grid[curZerRow][curZerCol] = 0;
            }
        }


        return mini;
    }

    // This formula is used to find the distance between 2 blocks in a grid.
    private static int manhattan(int curZerRow, int curZerCol, int curExtraRow, int curExtraCol) {
        return Math.abs(curZerRow - curExtraRow) + Math.abs(curZerCol - curExtraCol);
    }
}
