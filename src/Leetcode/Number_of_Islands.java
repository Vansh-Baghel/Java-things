//https://leetcode.com/problems/number-of-islands/
package Leetcode;

public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    findMat(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void findMat(int row, int col , char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return ;

        if (grid[row][col] != '1') return;

        grid[row][col] = 'V';

        findMat(row + 1 , col , grid);
        findMat(row - 1, col, grid);
        findMat(row , col + 1 , grid);
        findMat(row , col - 1, grid);
        return;
    }
}
