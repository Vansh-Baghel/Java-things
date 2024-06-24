package Leetcode;

import java.util.Arrays;

public class Buy_Two_Chocolates {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int sum = 0;

        sum += prices[0];
        sum += prices[1];

        return money - sum < 0 ? money : money - sum;
    }
}
