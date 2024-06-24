package Leetcode;

public class Game_of_Life {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife2(board);
    }

    static void gameOfLife(int[][] board) {
        int[] drow = {-1,-1,-1,0,0,1,1,1};
        int[] dcol = {-1,0,1,-1,1,-1,0,1};

        int n = board.length, m = board[0].length, cnt = 0, k = drow.length;
        int[][] nextLife = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nextLife[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    if (shallLive(i, j, cnt, n, m, k, drow, dcol, board)) nextLife[i][j] = 1;
                } else {
                    if (shallDie(i, j, cnt, n, m, k, drow, dcol, board)) nextLife[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = nextLife[i][j];
            }
        }
    }

    static boolean shallDie(int i, int j, int cnt, int n, int m, int k, int[] drow, int[] dcol, int[][] board) {
        for (int l = 0; l < k; l++) {
            int row = i + drow[l];
            int col = j + dcol[l];

            if (isValidRange(row, col, n, m) && board[row][col] == 1) {
                cnt++;
            }
        }

        if (cnt == 2 || cnt == 3) return false;
        return true;
    }

    static boolean shallLive(int i, int j, int cnt, int n, int m, int k, int[] drow, int[] dcol, int[][] board) {
        for (int l = 0; l < k; l++) {
            int row = i + drow[l];
            int col = j + dcol[l];

            if (isValidRange(row, col, n, m) && board[row][col] == 1) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    private static boolean isValidRange(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static void gameOfLife2(int[][] board) {
        int[] drow = {-1,-1,-1,0,0,1,1,1};
        int[] dcol = {-1,0,1,-1,1,-1,0,1};

        int n = board.length, m = board[0].length, cnt = 0, k = drow.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || board[i][j] < 1) {
                    if (shallLive2(i, j, cnt, n, m, k, drow, dcol, board)) board[i][j] = -1;
                } else {
                    if (shallDie2(i, j, cnt, n, m, k, drow, dcol, board)) board[i][j] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] > 1) board[i][j] = 0;
            }
        }
    }

    static boolean shallDie2(int i, int j, int cnt, int n, int m, int k, int[] drow, int[] dcol, int[][] board) {
        for (int l = 0; l < k; l++) {
            int row = i + drow[l];
            int col = j + dcol[l];

            if (isValidRange2(row, col, n, m) && (board[row][col] >= 1)) {
                cnt++;
            }
        }

        if (cnt == 2 || cnt == 3) return false;
        return true;
    }

    static boolean shallLive2(int i, int j, int cnt, int n, int m, int k, int[] drow, int[] dcol, int[][] board) {
        for (int l = 0; l < k; l++) {
            int row = i + drow[l];
            int col = j + dcol[l];

            // Greater than 1 because we are converting 1 to +1 whenever we want it to be dead.
            if (isValidRange2(row, col, n, m) && (board[row][col] >= 1)) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    private static boolean isValidRange2(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
