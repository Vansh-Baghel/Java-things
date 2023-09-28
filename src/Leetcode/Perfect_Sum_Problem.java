package Leetcode;

import java.util.Arrays;

public class Perfect_Sum_Problem {
    public static void main(String[] args) {
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int ans = perfectSum(arr, 10, 31);
        System.out.println(ans);
    }

    static int perfectSum(int arr[],int n, int sum) {
        int dp[][] = new int[n+1][sum+1];
        // 1 because at index 0, the sum is 0, therefore increase the count.
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(arr[i-1]<=j) dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]])%1000000007;
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    static int perfectSum2(int arr[],int n, int sum)
    {
        int mod = (int)(1e9 + 7);
        return countWays(arr, arr.length - 1, sum, mod);
    }

    static int countWays(int[] arr, int idx, int sum, int mod){
        if (idx == 0) {
            // If you pick or not pick, the sum will increase anyways in this case, therefore return 2.
            if (sum == 0 && arr[0] == 0) return 2;
            if (sum == 0 || sum == arr[0]) return 1;
            return 0;
        }
        // sum < 0 because when sumget is 0 for, left doesn't work, and array might also have the arrber 0.
        if (sum < 0) return 1;
        // If false then 0, then 1.

        int left = 0;
        if (arr[idx] <= sum) left= countWays(arr, idx - 1, sum - arr[idx], mod)%mod;
        int right = countWays(arr, idx - 1, sum, mod)%mod;
        return (left+right)%mod;
    }

    static int perfectSum3(int arr[],int n, int sum) {
        int mod = (int)(1e9 + 7);
        int dp[][]=new int[n][sum+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countWays2(arr,  n- 1, sum, mod, dp);
    }

    static int countWays2(int[] arr, int idx, int sum, int mod, int dp[][]){
        if (sum < 0) return 1;
        // If false then 0, then 1.
        if (idx == 0) {
            // If you pick or not pick, the sum will increase anyways in this case, therefore return 2.
            if (sum == 0 && arr[0] == 0) return 2;
            if (sum == 0 || sum == arr[0]) return 1;
            return 0;
        }
        if (dp[idx][sum] != -1) return dp[idx][sum];

        int left = 0;
        if (arr[idx] <= sum) left= countWays2(arr, idx - 1, sum - arr[idx], mod, dp)%mod;
        int right = countWays2(arr, idx - 1, sum, mod, dp)%mod;
        return dp[idx][sum] = (left+right)%mod;
    }
}
