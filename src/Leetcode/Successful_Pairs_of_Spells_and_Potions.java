package Leetcode;

import java.util.*;

public class Successful_Pairs_of_Spells_and_Potions {
    public static void main(String[] args) {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        int success = 16;

        System.out.println(Arrays.toString(successfulPairs2(spells, potions, success)));
    }

    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int s = 0, n = potions.length, e = n - 1, m = spells.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            ans[i] = binarySearchCount(spells[i], s, e, potions, success);
        }

        return ans;
    }

    private static int binarySearchCount(int prod, int s, int e, int[] potions, long success) {
        int possibleIdx = potions.length;

        while (s <= e){
            int  m = s + (e - s) / 2;

            if ((long)potions[m] * prod >= success) {
                possibleIdx=m;
                e = m - 1;
            } else if ((long)potions[m] * prod < success){
                s = m + 1;
            }
        }

        return potions.length - possibleIdx;
    }

    static int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int s = 0, n = potions.length, e = n - 1, m = spells.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            long ceil = (long) Math.ceil(1.0*success / spells[i]);

            if (ceil > potions[n - 1]) continue;

            ans[i] = binarySearchCount2(s, e, potions, ceil);
        }

        return ans;
    }

    private static int binarySearchCount2(int s, int e, int[] potions, long success) {
        int possibleIdx = 0;

        while (s <= e){
            int  m = s + (e - s) / 2;

            if ((long)potions[m] >= success) {
                possibleIdx=m;
                e = m - 1;
            } else if ((long)potions[m] < success){
                s = m + 1;
            }
        }

        return potions.length - possibleIdx;
    }
}