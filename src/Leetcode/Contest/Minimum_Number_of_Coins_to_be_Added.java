package Leetcode.Contest;

import java.util.Arrays;

public class Minimum_Number_of_Coins_to_be_Added {
    public static void main(String[] args) {
        int[] c = {1, 4, 10, 5, 7, 19};
        System.out.println(minimumAddedCoins(c, 19));
    }

    static int minimumAddedCoins(int[] coins, int target) {
        int res = 0, sum = 0, idx = 0;

        Arrays.sort(coins);

        for (int i = 1; i <= target; i++) {
            // If the current number is smaller or equal to i, then add the cur coin num in the res list, and increase the sum.
            if (idx < coins.length && coins[idx] <= i) {
                sum += coins[idx];
                idx++;
            } else {
                // If the sum is < i, then it means that the sum will take care of the i.
                if (sum >= i) continue;
                sum += i;
                res++;
            }
        }

        return res;
    }
}
