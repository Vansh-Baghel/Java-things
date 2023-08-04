package Leetcode;
import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = '.';
            }
        }
        dfs(0, ans, res);
        return res;
    }

    public void dfs(int col, char[][] ans, List<List<String>> res){
        if (col == ans.length){
            // Adding the string into the res.
            res.add(constructTheString(ans));
            return;
        }

        for (int row = 0; row < ans.length; row++) {
            if(validate(row, col, ans)){
                ans[row][col] = 'Q';
                dfs(col+1, ans, res);
                ans[row][col] = '.';
            }
        }
    }

    public boolean validate(int row, int col, char[][] ans) {
        int tempRow = row;
        int tempCol = col;

        // We just need to check previous nums.
        while(col >= 0){
            if(ans[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        col=tempCol;

        // Checking upper and backwards diagonal.
        while(row < ans.length && col >= 0){
            if(ans[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        row=tempRow;
        col=tempCol;

        // Checking the diagonals of previous range and downwards.
        while (row >= 0 && col >= 0){
            if (ans[row][col] == 'Q'){
                return false;
            }

            row--;
            col--;
        }

        return true;
    }

    public List<String> constructTheString(char[][] ans){
        List <String> res = new ArrayList<String>();
        for (int i = 0; i < ans.length; i++) {
            // Pushing the whole row at once, since the answer we need is in string format.
            String s = new String(ans[i]);
            res.add(s);
        }
        return res;
    }
}
