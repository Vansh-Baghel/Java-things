package Leetcode.Contest;

import java.util.*;

public class Plucking_Flowers {
    public static void main(String[] args) {

    }

    long maximumBeauty(int N, int K, int B[]) {
        long dp[][]=new long[N+1][K+1];
        for(long[] r: dp){
            Arrays.fill(r, -1);
        }
        return maxCount(0, 0, K, B, dp);
    }

    private long maxCount(int idx, int count, int K, int[] arr, long[][] dp) {
        if(count==idx) return 0;
        if (idx >= arr.length){
            if(count==K) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[idx][count]!=-1) return dp[idx][count];
        long pick = arr[idx] + maxCount(idx + 2, count++, K, arr, dp);
        long nonPick = 0 + maxCount(idx + 1, count, K, arr, dp);

        return dp[idx][count]=Math.max(pick, nonPick);
    }
}
