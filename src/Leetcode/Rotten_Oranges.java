import java.util.*;
// Creating Queue
class Pair {
    int row;
    int col;
    int time;
    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue< Pair > q = new LinkedList < > ();
        int countFresh = 0;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
//                    Adding in queue so that we can check the 4 directions for these indices only.
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else {
                    visited[i][j] = 0;
                }

                if (grid[m][n] == 1){
//                    Keeping fresh counter because we need to count the time of all oranges which are rotten. Even if 1 count is less, then we have to return -1.
                    countFresh++;
                }
            }
        }

//        Now lets change the 4 directions of rotten oranges
        int countRotten = 0;
        int time = 0;

//        up left down right order
        int[] numbersToAddInRowToMove = {-1, 0, 1, 0};
        int[] numbersToAddInColToMove = {0, 1, 0 , -1};

        while (!q.isEmpty()){
//           Starting with the topmost Pair from the queue.
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time, t);
            q.remove();
//            Looping in 4 directions only around indices which contains number 2 ie rotten.
            for (int i = 0; i < 4; i++) {
                int moveRow = r + numbersToAddInRowToMove[i];
                int moveCol = c + numbersToAddInColToMove[i];
//                the movedRow and movedCol must be smaller than m and n because those are the lengths which usually are 1 more ie if mat is 3*3 then length is 4 for row and col each
//                Checking the position out of bound case and changing only if element is 1 as we dont need to rotten empty block and checking if its visited or not, if its visited already, then dont need to repeat the rottening of orange.
                if (moveRow >= 0 && moveCol >= 0 && moveRow < m && moveCol < n && visited[moveRow][moveCol] == 0 && grid[moveRow][moveCol] == 1){
//                    Whenever we turn a fresh orange into rotten one, we need to add that block in queue to check its 4 directions and add 2 in the visited matrix so that further checkings could be done.
                    q.add(new Pair(moveRow , moveCol , t + 1));
                    visited[moveRow][moveCol] = 2;
                    countRotten++;
                };
            }
        }
        if (countFresh == countRotten) {
            return time;
        };
        return -1;
    }
}

