package Leetcode;
import java.util.*;

public class Rat_in_a_Maze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        findPath(m, 4);
    }

    static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis= new boolean[m.length][m.length];
        vis[0][0] = true;

//        if (m[0][0] == 1) onePathPrint(m, n, 0, 0, list, ans, vis);

        if (m[0][0] == 1) multiplePathPrint(m, n, 0, 0, "", ans, vis);
        return ans;
    }

//            CODE TO PRINT MULTIPLE PATHS
        static void multiplePathPrint(int[][] m, int n, int row, int col, String str, ArrayList<String> ans, boolean[][] vis) {
            if (row == n - 1 && col == n - 1) {
                ans.add(str);
                return;
            }

        int[] drow = {+1, 0, -1, 0};
        int[] dcol = {0, +1 , 0 , -1};
        String dir = "DRUL";

            for (int i = 0; i < 4; i++) {
                int nextRow = row + drow[i];
                int nextCol = col + dcol[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n &&
                        !vis[nextRow][nextCol] && m[nextRow][nextCol] == 1) {

                    vis[row][col] = true;
                    multiplePathPrint(m, n, nextRow, nextCol, str + dir.charAt(i), ans, vis);
                    vis[row][col] = false;
                }
            }
        }
}

//    static void onePathPrint(int[][] m, int n, int row, int col, StringBuilder list, ArrayList<String> ans, boolean[][] vis) {
//        CODE TO PRINT 1 PATH
//        if (row==n-1 && col == n-1) {
//            System.out.println(list);
//            ans.add(list.toString());
//            return;
//        }
//
//            int drow = row + 1;
//            int urow = row - 1;
//            int rcol = col + 1;
//            int lcol = col - 1;
//
//            if (drow < m.length && m[drow][col] != 0 && !vis[drow][col]) {
//                list.append("D");
//                vis[drow][col] = true;
//                onePathPrint(m, n, drow, col, list, ans, vis);
//                vis[drow][col] = false;
//            } else if (urow >= 0 && m[urow][col] != 0 && !vis[urow][col]) {
//                list.append("U");
//                vis[urow][col] = true;
//                onePathPrint(m, n, urow, col, list, ans, vis);
//                vis[urow][col] = false;
//            } else if (rcol < m.length && m[row][rcol] != 0 && !vis[row][rcol]) {
//                list.append("R");
//                vis[row][rcol] = true;
//                onePathPrint(m, n, row, rcol, list, ans, vis);
//                vis[row][rcol] = false;
//            } else if (lcol >= 0 && m[row][lcol] != 0 && !vis[row][lcol]) {
//                list.append("L");
//                vis[row][lcol] = true;
//                onePathPrint(m, n, row, lcol, list, ans, vis);
//                vis[row][lcol] = false;
//            }
//        }

