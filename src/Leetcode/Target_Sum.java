package Leetcode;

public class Target_Sum {
    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum+=arr[i];
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 == 1) return 0;
        // Write your code here.
        return countWays(arr, (totalSum - target) / 2);
    }

    public static int countWays(int[] arr, int sum) {
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
