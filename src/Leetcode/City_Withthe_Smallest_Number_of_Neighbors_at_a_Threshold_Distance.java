package Leetcode;

public class City_Withthe_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };

        int ans = findCity(4,4, matrix, 4);
        System.out.println(ans);
    }
    static int findCity(int n, int m, int[][] edges,int distanceThreshold){
        int ans= 0;
        int[][] shortestPath = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPath[i][j] = Integer.MAX_VALUE;
                if (i == j) shortestPath[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            shortestPath[u][v]=wt;
            shortestPath[v][u]=wt;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (shortestPath[i][via] == Integer.MAX_VALUE ||
                            shortestPath[via][j] == Integer.MAX_VALUE)
                        continue;
                    shortestPath[i][j] = Math.min(shortestPath[i][j] , shortestPath[i][via] + shortestPath[via][j]);
                }
            }
        }

        int minCnt=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt=0;
            for (int j = 0; j < n; j++) {
                if (shortestPath[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if (cnt <= minCnt) {
                ans = i;
                minCnt=cnt;
            }
        }

        return ans;
    }
}
