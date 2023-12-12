package Leetcode;

import java.util.Arrays;

public class Eliminate_Maximum_Number_of_Monsters {
    public static void main(String[] args) {
        int[] dist = {1,3,4};
        int[] speed = {1,1,1};

        System.out.println(eliminateMaximum(dist, speed));
    }
    static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = (int)(Math.ceil((double) dist[i] / speed[i]));
        }

        Arrays.sort(time);

        int cnt = 1, timePassed = 1;

        for (int i = 1; i < n; i++) {
            if (time[i] - timePassed <= 0) return cnt;

            cnt++;
            timePassed++;
        }
        return cnt;
    }
}
