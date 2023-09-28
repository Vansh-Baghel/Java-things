package Leetcode;

import java.util.Arrays;

public class Minimum_Elements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(minimumElements4(arr, 7));
    }
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int ans = minimumCount(num, n -1, x);
        // We have to return -1 if the answer doesn't exist.
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    private static int minimumCount(int[] num, int n, int x) {
        if (n == 0) {
            if (x % num[n] == 0) return x / num[n];
            else return (int)1e9;
        }

        int pick = (int)1e9;
        if (num[n] <= x) pick= 1 + minimumCount(num, n, x-num[n]);
        int notPick = minimumCount(num, n - 1,x);

        return Math.min(pick, notPick);
    }

    public static int minimumElements2(int num[], int x) {
        int n = num.length;
        int[][] dp=new int[n][x+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        int ans = minimumCount2(num, n -1, x, dp);
        // We have to return -1 if the answer doesn't exist.
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    private static int minimumCount2(int[] num, int n, int x,int[][] dp) {
        if (n == 0) {
            if (x % num[n] == 0) return x / num[n];
            else return (int)1e9;
        }

        if (dp[n][x] != -1) return dp[n][x];

        int pick = (int)1e9;
        if (num[n] <= x) pick= 1 + minimumCount2(num, n, x-num[n], dp);
        int notPick = minimumCount2(num, n - 1,x,dp);

        return dp[n][x]= Math.min(pick, notPick);
    }

    public static int minimumElements3(int num[], int x) {
        int n = num.length;
        int[][] dp=new int[n][x+1];

        // i/num[0] will return the count which we can store in 1st row.
        for(int i=0; i<=x; i++){
            if (i % num[0] == 0) dp[0][i] = i/num[0];
            else dp[0][i] = (int)1e9;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= x; tar++) {
                int pick = (int)1e9;
                if (num[idx] <= tar) pick= 1 + dp[idx][tar-num[idx]];
                int notPick = dp[idx-1][tar];

                dp[idx][tar] = Math.min(pick, notPick);
            }
        }
        int ans = dp[n-1][x];
        if(ans >=(int)1e9) return -1;
        return ans;
    }

    public static int minimumElements4(int num[], int x) {
        int n = num.length;
        int[] prev=new int[x+1];
        int[] cur=new int[x+1];

        // i/num[0] will return the count which we can store in 1st row.
        for(int i=0; i<=x; i++){
            if (i % num[0] == 0) prev[i] = i/num[0];
            else prev[i] = (int)1e9;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int tar = 0; tar <= x; tar++) {
                int pick = (int)1e9;
                if (num[idx] <= tar) pick= 1 + prev[tar-num[idx]];
                int notPick = prev[tar];

                cur[tar] = Math.min(pick, notPick);
            }
            prev=cur;
        }
        int ans = prev[x];
        if(ans >=(int)1e9) return -1;
        return ans;
    }
}
