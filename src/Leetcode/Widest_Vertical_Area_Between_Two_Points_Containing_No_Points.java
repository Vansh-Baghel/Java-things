package Leetcode;

import java.util.Arrays;

public class Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
    static int maxWidthOfVerticalArea(int[][] points) {
        int maxi = Integer.MIN_VALUE, idx = 0, n = points.length;
        int[] x_dist = new int[n];

        for (int[] point: points){
            x_dist[idx++] = point[0];
        }

        Arrays.sort(x_dist);

        for (int i = 0; i < n - 1; i++) {
            maxi = Math.max(maxi, x_dist[i+1] - x_dist[i]);
        }

        return maxi;
    }
}
