package Leetcode;

import java.util.*;

public class Minimum_Cost_to_Convert_String_I {
    static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.distance = distance;
            this.node = node;
        }
    }

    static void shortest_distance(long[][] matrix) {
        int n = matrix.length;

        for (int via = 0; via < n; via++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = Math.min(matrix[r][via] + matrix[via][c], matrix[r][c]);
                }
            }
        }
    }

    static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Because will store alpha as nums.
        long[][] adjMatrix = new long[26][26];
        long res = 0;

        formMatrix(original, changed, cost, adjMatrix);

        shortest_distance(adjMatrix);

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a', t = target.charAt(i) - 'a';
            if (s != t){
                if (adjMatrix[s][t] != 10000000) {
                    res += adjMatrix[s][t];
                } else return -1;
            }
        }

        return res;
    }

    private static void formMatrix(char[] original, char[] changed, int[] cost, long[][] adjMatrix) {
        int n = original.length;

        for (long[] r: adjMatrix){
            // Max could be 2000 * 26
            Arrays.fill(r, 10000000);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], adjMatrix[original[i] - 'a'][changed[i] - 'a']);
            }
        }
    }
}
