package Leetcode;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
//      If this condition is true, then else if wala wont be running. Therefore jo purane values hai, those wont be into consideration.
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
//            current value - prev minValue will get us the maximum profit. This will run when the above minPrice condition is false.
            else if (maxProfit < prices[i] - minPrice) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
