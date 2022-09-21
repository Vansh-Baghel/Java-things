package Recursion.Backtracking;

import java.util.ArrayList;

public class ObstacleMaze {
    public static void main(String[] args) {
//       The center element of the maze has caught fire so you cant go from there.
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestrictions("", board, 0, 0);
        System.out.println(pathRestrictionsArr("", board, 0, 0));
    }

    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
//        We started the matrix count from 0 , and in other sums we did from 3 . Like if 3 rows and 3 cols , then naming were 3,2,1 from 1st to last row. This time naming was 0,1,2 . Therefore when elements reach 2,2 it means that we have found the ans.
        if (r == maze.length - 1 && c == maze.length - 1){
            System.out.println(p);
            return;
        }

//        If the value if the element is false ,then just return nothing . This will stop all the recursions from that path.
        if (!maze[r][c]){
            return;
        }

//       The length of r must be smaller than the 2 if the length of row is 3. Because it already runs 2 times as r = 0 , 0 < 2 (first shift to down), 1 < 2 (second shift to down, now it reached the last row), now any further shift will push the r out of the box.
        if (r < maze.length - 1){
            pathRestrictions(p + 'D' , maze , r + 1 , c);
        }

//        Its length must be smaller than the length of the row k elements because they define the horizontal length of the matrix.
        if (c < maze[r].length - 1){
            pathRestrictions(p + 'R' , maze , r , c + 1);
        }
    }

    static ArrayList<String> pathRestrictionsArr(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze.length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (!maze[r][c]){
            return list;
        }

        if (r < maze.length - 1){
            list.addAll(pathRestrictionsArr(p + 'D' , maze , r + 1 , c));
        }

        if (c < maze[r].length - 1){
            list.addAll(pathRestrictionsArr(p + 'R' , maze , r , c + 1));
        }
        return list;
    }
}

