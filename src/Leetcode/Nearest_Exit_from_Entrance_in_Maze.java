package Leetcode;

import java.util.*;

public class Nearest_Exit_from_Entrance_in_Maze {
    static class Tuple{
        int count;
        Pair pair;
        public Tuple(int count, Pair pair){
            this.count = count;
            this.pair = pair;
        }
    }

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static char[][] convertToCharMatrix(String[] mazeStrings) {
        char[][] maze = new char[mazeStrings.length][];
        for (int i = 0; i < mazeStrings.length; i++) {
            maze[i] = mazeStrings[i].toCharArray();
        }
        return maze;
    }

    public static void main(String[] args) {
        String[] mazeStrings = {
                "+.+++++",
                "+.+...+",
                "+.+.+.+",
                "+...+.+",
                "+++++.+"
        };

        char[][] maze = convertToCharMatrix(mazeStrings);
        int[] entrance = {0,1};
        System.out.println(nearestExit(maze, entrance));
    }

    static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
//        boolean[][] vis = new boolean[n][m];
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, new Pair(entrance[0],entrance[1])));
//        vis[entrance[0]][entrance[1]] = true;
        maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()){
            Tuple top = q.poll();
            int r = top.pair.row;
            int c = top.pair.col;
            int cnt = top.count;

            for (int i = 0; i < drow.length; i++) {
                int row = drow[i] + r;
                int col = dcol[i] + c;

//                if (row >= 0 && row < n && col >= 0 && col < m && !vis[row][col] && maze[row][col] == '.'){
                if (row >= 0 && row < n && col >= 0 && col < m && maze[row][col] == '.'){
                    maze[row][col] = '+';
                    if (row == 0 || col == 0 || row == n - 1 || col == m - 1) return cnt+1;
//                    vis[row][col] = true;
                    q.add(new Tuple(cnt+1, new Pair(row, col)));
                }
            }
        }

        return -1;
    }
}
