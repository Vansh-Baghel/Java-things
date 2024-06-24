package Leetcode;

public class Number_of_Possible_Sets_of_Closing_Branches {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;

        // 1 << n is a right shift which indicates Math.pow(2, n) ie 2 ^ n.
        // We are running the loop for (2 ^ n) - 1 times because there are total (2 ^ n) - 1 possibilities for n nodes. EG: n = 3 can have total 7 possiblities of removing the roads.
        for (int set = 0; set < (1 << n); set++){
            int[][] shortestDist = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    shortestDist[j][k] = (int)(1e9); // Initialize with a large value
                }
            }

            // Check if u and v are part of the set of not.
            for (int[] road: roads){
                int u = road[0];
                int v = road[1];
                int wt = road[2];

                // set is basically number from 0 which represents which nodes are present, and which are removed. If by right shift and performing & operator, the output is 1, then it means that, that u or v are present and we can consider. Warna we have to ignore all the paths of cancelled roads
                if ((set >> u & 1) == 1 && (set >> v & 1) == 1 ) {
                    // min because if 1 tak first dist is 10, then 20, toh vo 20 consider krlega as shortest distance, which will be wrong.
                    shortestDist[u][v] = Math.min(shortestDist[u][v], wt);
                    shortestDist[v][u] = Math.min(shortestDist[v][u], wt);
                }
            }

            // Diagonal ko 0 karo
            for(int i = 0; i < n; i++){
                shortestDist[i][i] = 0;
            }

            // Floyd Warshall lagao
            for (int via = 0; via < n; via++){
                for (int u = 0; u < n; u++){
                    for (int v = 0; v < n; v++){
                        shortestDist[u][v] = Math.min(shortestDist[u][via] + shortestDist[via][v], shortestDist[u][v]);
                    }
                }
            }

            // Check if the shortest distance is not greater than the maxDistance
            boolean isSmaller = true;

            // If delete krne k baad bhi koi distance is greater than maxDistance, then just break the loop, and dont consider that pair
            for (int u = 0; u < n; u++){
                for (int v = 0; v < n; v++){
                    if (u == v) continue;
                    if ((set >> u & 1) == 1 && (set >> v & 1) == 1 ) {
                        if (shortestDist[u][v] > maxDistance){
                            isSmaller = false;
                            break;
                        }
                    }
                }
            }

            if (isSmaller) res++;
        }

        return res;
    }
}
