package Leetcode;

public class Coin_Mining {
    public static void main(String[] args) {
        int[][] nums = {
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,81,0,0,0,0},
                {67,0,0,0,0,0,96},
                {0,0,0,0,19,0,0},
                {0,52,0,1,0,0,0},
                {0,0,95,0,0,9,75}
        };

        System.out.println(maximumCoins(nums.length, nums));
    }

    public static int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static int maximumCoins(int N, int[][] grid) {
        // code here
        boolean[][] vis = new boolean[N][N];
        int[] res = new int[1];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                vis[i][j]=true;
                if (isWeak(i, j) && grid[i][j] != 0) dfs(i, j, N, grid[i][j], res, vis, grid);
                vis[i][j]=false;
            }
        }

        return res[0];
    }

    public static void dfs(int i, int j, int n, int sum, int[] res, boolean[][] vis, int[][] grid){
        res[0] = Math.max(res[0], sum);

        for (int[] del: d){
            int r = i + del[0];
            int c = j + del[1];

            if (r >= 0 && c >= 0 && r < n && c < n && !vis[r][c] && grid[r][c] != 0){
                vis[r][c] = true;
                sum += grid[r][c];
                dfs(r,c,n,sum,res,vis,grid);
                sum -= grid[r][c];
                vis[r][c] = false;
            }
        }
    }

    public static boolean isWeak(int i, int j){
        return ((i + j) % 2) == 1;
    }


}
