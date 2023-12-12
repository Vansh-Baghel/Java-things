package Leetcode;

public class Floyd_Warshall {
    public void shortest_distance(int[][] matrix) {

        // You can use Dijkstra if the graph doesn't have negative cycle. It will not work in that case, otherwise dijkstra is best.
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // -1 means it cannot be reached, ie, there is no path for that node.
                // Assigning max here so it doesn't get involved since we are picking min, and in the end changing it to -1.
                if(matrix[i][j] == -1) matrix[i][j] = (int)(1e9);
                // Diagonals will always be 0
                else if (i == j) matrix[i][j] = 0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j] , matrix[i][via] + matrix[via][j]);
                }
            }
        }

        // Reassigning the unreached node from max to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)(1e9)) matrix[i][j] = -1;
            }
        }
    }




























    public void shortest_distance2(int[][] matrix) {
        // Code here
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Converting -1 temporarily to high value
                if (matrix[i][j] == -1) matrix[i][j] = 10000;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                        matrix[row][col] = Math.min(matrix[row][col], matrix[row][via] + matrix[via][col]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Converting -1 temporarily to high value
                if (matrix[i][j] == 10000) matrix[i][j] = -1;
            }
        }
    }
}
