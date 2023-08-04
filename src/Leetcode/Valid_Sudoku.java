package Leetcode;

public class Valid_Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
                { '2', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '4', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '6', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '8', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '9', '.', '.', '.', '.', '.', '.', '.', '.' }
        };

        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch != '.') {

                    // Changing the current as '.', so it doesn't consider itself.
                    board[row][col]='.';
                    if (!validateSudoku(board, row, col, ch)) {
                        return false;
                    }

                    // Changing it back to original state.
                    board[row][col]=ch;
                }
            }
        }
        return true;
    }

    static boolean validateSudoku(char[][] board, int row, int col, char ch) {

        // Checking if ch exists anywhere in the row
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == ch){
                return false;
            }

            // Checking if ch exists anywhere in the col
            if(board[row][i] == ch){
                return false;
            }

            // Checking for 3*3 spaces.
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }
}

