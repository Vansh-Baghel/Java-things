package Leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public static void main(String[] args) {
        int[] values = {3,2,6,5,0,3,1,4};
        int n = values.length;
        System.out.println(maximumProfit(values, n, 3));
    }

    public static int maximumProfit(int[] values, int n, int k){
        int[][][] dp = new int[n+1][2][k+1];

        for (int idx = 0; idx < n; idx++) {
            for (int cap = 0; cap <= 1; cap++) {
                dp[idx][0][cap] = 0;
                dp[idx][1][cap] = 0;
            }
        }

        for (int idx = 0; idx < n; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }

        int pick;
        int notPick;
        int profit=0;

        for (int idx = n-1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    // Here we will buy first
                    if (buy == 0){
                        pick = -values[idx] + dp[idx + 1][1][cap];
                        notPick = dp[idx + 1][0][cap];
                    }

                    else {
                        pick = values[idx] + dp[idx + 1][0][cap-1];
                        notPick = dp[idx + 1][1][cap];
                    }
                    profit = Math.max(pick, notPick);
                    dp[idx][buy][cap]=profit;
                }
            }
        }
        return dp[0][0][k];
    }
}
