package Leetcode;

public class Minimum_Time_Visiting_All_Points {
    static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;

        for (int i = 0; i < n - 1; i++) {
            int first = Math.abs(points[i+1][0] - points[i][0]);
            int sec = Math.abs(points[i+1][1] - points[i][1]);
            ans += Math.max(first, sec);
        }

        return ans;
    }
}
