package Leetcode;

import java.util.Arrays;

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;

        System.out.println(minEatingSpeed(piles, h));
    }
    static int minEatingSpeed(int[] piles, int h) {
        int s = 0, e = Integer.MIN_VALUE;

        for (int pile: piles){
            e = Math.max(e, pile);
        }

        while (s < e){
            int m = s + (e - s)/2;

            if (canEatAll(piles, m, h)) e = m;
            else {
                s = m + 1;
            }
        }

        return s;
    }

    private static boolean canEatAll(int[] piles, int m, int h) {
        int sum = 0;

        for (int pile: piles){
            sum += (int) Math.ceil(1.0 * pile/m);
        }

        return sum >= h;
    }
}
