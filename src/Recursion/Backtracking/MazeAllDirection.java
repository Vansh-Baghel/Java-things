package Recursion.Backtracking;

import java.util.ArrayList;

public class MazeAllDirection {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        mazeAll("", board, 0, 0);
        System.out.println(mazeAllArray("", board, 0, 0));
    }

    static ArrayList<String> mazeAllArray(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (!maze[r][c]) {
            return list;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            list.addAll(mazeAllArray(p + 'D', maze, r + 1, c));
        }
        if (c < maze[0].length - 1) {
            list.addAll(mazeAllArray(p + 'R', maze, r, c + 1));
        }
        if (r > 0) {
            list.addAll(mazeAllArray(p + 'U', maze, r - 1, c));
        }
        if (c > 0) {
            list.addAll(mazeAllArray(p + 'L', maze, r, c - 1));
        }

        maze[r][c] = true;
        return list;
    }

    static void mazeAll(String p , boolean[][] maze , int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

//        OMG, Dont forget to write this condition because if the block condition is false we have to make it return to the prev block . So even if the block has no false condition inside it, make sure to use this.
        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            mazeAll(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            mazeAll(p + 'R', maze, r, c + 1);
        }
        if (r > 0) {
            mazeAll(p + 'U', maze, r - 1, c);
        }
        if (c > 0) {
            mazeAll(p + 'L', maze, r, c - 1);
        }

        maze[r][c] = true;

    }
}
