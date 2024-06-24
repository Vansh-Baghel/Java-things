package Leetcode.Contest;

public class Maximum_Area_of_Longest_Diagonal_Rectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double diag = Integer.MIN_VALUE;
        int n = dimensions.length, res = 0;

        for (int[] dimension: dimensions) {
            double curDiag = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);

            if (curDiag > diag) {
                res = dimension[0] * dimension[1];
                diag = curDiag;
            } else if (curDiag == diag) {
                res = Math.max(dimension[0] * dimension[1], res);
            }
        }

        return res;
    }
}
