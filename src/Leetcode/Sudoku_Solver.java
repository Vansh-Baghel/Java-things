package Leetcode;

public class Sudoku_Solver {
    public static void main(String[] args) {
        char[][] board = {
                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '7', '.', '.', '.', '.', '3', '1', '.'},
                {'.', '3', '.', '1', '.', '.', '8', '.', '9'},
                {'.', '8', '6', '3', '.', '.', '5', '.', '5'},
                {'.', '.', '9', '.', '6', '.', '.', '1', '3'},
                {'.', '.', '.', '.', '2', '5', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        System.out.println(solveSudoku(board));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (validateSudoku(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solveSudoku(board)) {
                                return true;
                            }
                        }

                        // IF validateSudoku doesn't run, we will come at this line.
                    }
                    return false;
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

