package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        };

        return low;
    }
    static boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            while (i < bloomDay.length && bloomDay[i] <= day) {
                count++;
                i++;

                if (count >= m * k) {
                    return true;
                }
            }
        }

        return false;
    }
}
