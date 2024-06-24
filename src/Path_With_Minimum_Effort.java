public class Path_With_Minimum_Effort {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(MinimumEffort(rows, columns, heights));
    }

    static int res = Integer.MAX_VALUE;
    static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
//        int[][] vis = new int[rows][columns];
        int cur = 0;

        solve(0, 0, rows, columns, heights, cur);
        return res;
    }

    static void solve(int i, int j, int r, int c, int[][] heights, int cur) {
        if (i < 0 || i >= r || j < 0 || j >= c) {
            return;
        }

        if (i == r - 1 && j == c - 1) {
            res = Math.min(cur, res);
            return;
        }

        if (i + 1 < r && heights[i][j] > 0) {
            int diff = Math.abs(heights[i][j] - heights[i + 1][j]);
            heights[i][j] *= -1;
            solve(i + 1, j, r, c, heights, Math.max(cur, diff));
            heights[i][j] *= -1;
        }

        if (i - 1 >= 0 && heights[i][j] > 0) {
            int diff = Math.abs(heights[i][j] - heights[i - 1][j]);
            heights[i][j] *= -1;
            solve(i - 1, j, r, c, heights, Math.max(cur, diff));
            heights[i][j] *= -1;
        }

        if (j + 1 < c && heights[i][j] > 0) {
            int diff = Math.abs(heights[i][j] - heights[i][j + 1]);
            heights[i][j] *= -1;
            solve(i, j + 1, r, c, heights, Math.max(cur, diff));
            heights[i][j] *= -1;
        }

        if (j - 1 >= 0 && heights[i][j] > 0) {
            int diff = Math.abs(heights[i][j] - heights[i][j - 1]);
            heights[i][j] *= -1;
            solve(i, j - 1, r, c, heights, Math.max(cur, diff));
            heights[i][j] *= -1;
        }
    }
}
