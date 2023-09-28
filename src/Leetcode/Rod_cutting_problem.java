package Leetcode;
import java.util.Arrays;

public class Rod_cutting_problem {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10};
        System.out.println(cutRod(arr, arr.length));
    }

    public static int cutRod(int price[], int n) {
        return maxCount(price, n-1, n);
    }

    private static int maxCount(int[] price, int idx, int totalCnt) {
        if (idx == 0) return totalCnt * price[0];

        int notPick = maxCount(price, idx - 1, totalCnt);
        int pick = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= totalCnt) pick = maxCount(price, idx, totalCnt - rodLength) + price[idx];
        return Math.max(pick, notPick);
    }

    public static int cutRod2(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int[] r: dp) Arrays.fill(r, -1);
        return maxCount2(price, n-1, n, dp);
    }

    private static int maxCount2(int[] price, int idx, int totalCnt, int[][] dp) {
        if (idx == 0) return totalCnt * price[0];

        if (dp[idx][totalCnt] != -1) return dp[idx][totalCnt];

        int notPick = maxCount2(price, idx - 1, totalCnt, dp);
        int pick = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= totalCnt) pick = maxCount2(price, idx, totalCnt - rodLength, dp) + price[idx];
        return dp[idx][totalCnt]= Math.max(pick, notPick);
    }

    public static int cutRod3(int price[], int n) {
        int[][] dp = new int[n][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int totalCnt = 0; totalCnt <= n; totalCnt++) {
                int notPick = dp[idx - 1][totalCnt];
                int pick = Integer.MIN_VALUE;
                int rodLength = idx + 1;
                if (rodLength <= totalCnt) pick = dp[idx][totalCnt - rodLength] + price[idx];
                dp[idx][totalCnt]= Math.max(pick, notPick);
            }
        }
        return dp[n-1][n];
    }

    public static int cutRod4(int price[], int n) {
        int[] cur = new int[n+1];

        for (int i = 0; i <= n; i++) {
            cur[i] = i * price[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int totalCnt = 0; totalCnt <= n; totalCnt++) {
                int notPick = cur[totalCnt];
                int pick = Integer.MIN_VALUE;
                int rodLength = idx + 1;
                if (rodLength <= totalCnt) pick = cur[totalCnt - rodLength] + price[idx];
                cur[totalCnt]= Math.max(pick, notPick);
            }
        }
        return cur[n];
    }
}
