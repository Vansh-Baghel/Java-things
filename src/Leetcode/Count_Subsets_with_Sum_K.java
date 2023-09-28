package Leetcode;

import java.util.Arrays;

public class Count_Subsets_with_Sum_K {
    public static void main(String[] args) {
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int ans = findWays(arr, 31);
        System.out.println(ans);
    }

    public static int findWays(int[] arr, int sum) {
        int mod = (int)(1e9 + 7);
        return countWays(arr, arr.length - 1, sum, mod);
    }

    static int countWays(int[] arr, int idx, int sum, int mod){
        if (idx == 0) {
            if (sum == 0 && arr[0] == 0) return 2;
            if (sum == 0 || sum == arr[0]) return 1;
            return 0;
        }
        
        if (sum < 0) return 1;
        // If false then 0, then 1.

        int left = 0;
        if (arr[idx] <= sum) left= countWays(arr, idx - 1, sum - arr[idx], mod)%mod;
        int right = countWays(arr, idx - 1, sum, mod)%mod;
        return (left+right)%mod;
    }

    public static int findWays2(int[] arr, int sum) {
        int n = arr.length;
        int mod = (int)(1e9 + 7);
        int dp[][]=new int[n][sum+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countWays2(arr,  n- 1, sum, mod, dp);
    }

    static int countWays2(int[] arr, int idx, int sum, int mod, int dp[][]){
        if (sum == 0) return 1;
        // If false then 0, then 1.
        if (idx == 0) return arr[idx] == sum ? 1 : 0;

        if (dp[idx][sum] != -1) return dp[idx][sum];

        int left = 0;
        if (arr[idx] <= sum) left= countWays2(arr, idx - 1, sum - arr[idx], mod, dp)%mod;
        int right = countWays2(arr, idx - 1, sum, mod, dp)%mod;
        return dp[idx][sum] = (left+right)%mod;
    }

    public static int findWays3(int[] arr, int sum) {
        int n = arr.length;
        int mod = (int)(1e9 + 7);
        int[] prev = new int[sum+1];

        if(arr[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(arr[0]!=0 && arr[0]<=sum) prev[arr[0]] = 1;  // 1 case -pick

        for (int idx = 1; idx < n; idx++) {
            int cur[]=new int[sum+1];
            cur[0] = 1;

            for (int k = 0; k <= sum; k++) {
                int left = 0;
                if (arr[idx] <= k) left= prev[k- arr[idx]];
                int right = prev[k];
                cur[k] = (left+right)%mod;
            }
            prev=cur;
        }
        return prev[sum];
    }
}
