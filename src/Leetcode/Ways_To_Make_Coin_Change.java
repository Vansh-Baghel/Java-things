package Leetcode;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;

public class Ways_To_Make_Coin_Change {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(countWaysToMakeChange(arr, 4));
    }
    public static long countWaysToMakeChange(int denominations[], int value) {
        //write your code here
        return totalWays(denominations, denominations.length - 1, value);
    }

    static long totalWays(int[] a, int idx, int tar) {
        if (tar == 0) return 1;
        if (idx == 0) return tar % a[idx] == 0 ?  1 : 0;

        long notPick = totalWays(a, idx - 1, tar);
        long pick = 0;
        if (tar >= a[idx]) pick = totalWays(a, idx, tar - a[idx]);
        return notPick + pick;
    }

    public static long countWaysToMakeChange2(int denominations[], int value) {
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n][value+1];
        for (long[] r: dp) Arrays.fill(r, -1);

        return totalWays2(denominations, denominations.length - 1, value,dp);
    }

    // Using Memoiation
    static long totalWays2(int[] a, int idx, int tar,long[][] dp) {
        if (tar == 0) return 1;
        if (idx == 0) return tar % a[idx] == 0 ?  1 : 0;

        if (dp[idx][tar] != -1) return dp[idx][tar];

        long notPick = totalWays2(a, idx - 1, tar,dp);
        long pick = 0;
        if (tar >= a[idx]) pick = totalWays2(a, idx, tar - a[idx],dp);
        return dp[idx][tar] = notPick + pick;
    }

    // Using Tabulation
    public static long countWaysToMakeChange3(int denominations[], int value) {
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n][value+1];

        for (int i = 0; i <= value; i++) {
            if (i % denominations[0] == 0) dp[0][i] = 1;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= value; tar++) {
                long notPick = dp[idx - 1][tar];
                long pick = 0;
                if (tar >= denominations[idx]) pick = dp[idx][tar - denominations[idx]];
                dp[idx][tar] = notPick + pick;
            }
        }
        return dp[n-1][value];
    }

    // Using Optimized approach
    public static long countWaysToMakeChange4(int denominations[], int value) {
        //write your code here
        int n = denominations.length;
        long[] prev = new long[value+1];
        long[] cur = new long[value+1];

        for (int i = 0; i <= value; i++) {
            if (i % denominations[0] == 0) prev[i] = 1;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= value; tar++) {
                long notPick = prev[tar];
                long pick = 0;
                if (tar >= denominations[idx]) pick = cur[tar - denominations[idx]];
                cur[tar] = notPick + pick;
            }
            prev=cur;

        }
        return prev[value];
    }
}
