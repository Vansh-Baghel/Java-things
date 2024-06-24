package Leetcode;

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(nums, m));
    }

    static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int minForce = 1;
        int maxForce = position[n - 1] - position[0];

        int res = 0;

        while (minForce <= maxForce){
            int midForce = minForce + (maxForce - minForce) / 2;
            if (ballCanBePlaced(position, midForce, m)) {
                res = midForce;
                minForce = midForce + 1;
            } else maxForce = midForce - 1;
        }

        return res;
    }

    static boolean ballCanBePlaced(int[] position, int minDistance, int m){
        int ballsPlaced = m;
        // 1st position par placed
        int prev = position[0];
        ballsPlaced--;

        for (int i = 1; i < position.length; i++){
            int cur = position[i];
            if (cur - prev >= minDistance) {
                prev = cur;
                ballsPlaced--;
            }

            if (ballsPlaced <= 0) return true;
        }

        return false;
    }
}
