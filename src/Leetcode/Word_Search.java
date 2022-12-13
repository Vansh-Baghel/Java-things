//https://leetcode.com/problems/word-search/
package Leetcode;

public class Word_Search {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'} , {'S','F','C','S'} , {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board , word));
    }

    static boolean exist(char[][] board, String word) {
        int n = board.length;
        int c = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                //      Checking neighbour elements for letters whose first letter match.
                if (board[i][j] == word.charAt(0) && checkMatrix(board , i , j , word , 0)) return true;
            }
        }
        return false;
    }

    static boolean checkMatrix(char[][] board , int i , int j , String word , int wordIndex ){
        if (wordIndex == word.length() - 1){
            return true;
        }

        board[i][j] -= 65;

        //      check the upper number only if the row is below 1st row else it will go out of bound.
        //      here 0 is the 1st index , don't get confused , 1st row is the 0th index.
        if (i > 0 && board[i-1][j] == word.charAt(wordIndex + 1) && checkMatrix(board , i - 1 , j , word , wordIndex + 1)){
            return true;
        }

        //      check left only if the col is more than 1st col , else out of bound.
        if (j > 0 && board[i][j - 1] == word.charAt(wordIndex + 1) && checkMatrix(board , i , j  - 1 , word , wordIndex + 1)){
            return true;
        }

        //      check the below number only if the row is till the second last row else it will go out of bound.
        if (i < board.length - 1 && board[i+1][j] == word.charAt(wordIndex + 1) && checkMatrix(board , i + 1 , j , word , wordIndex + 1)){
            return true;
        }

        //      check the right number only if the col is till lesser than length else it will go out of bound.
        if (j < board[0].length - 1 && board[i][j+1] == word.charAt(wordIndex + 1) && checkMatrix(board , i , j + 1  , word , wordIndex + 1)){
            return true;
        }

        board[i][j] += 65;
        return false;
    }
}

