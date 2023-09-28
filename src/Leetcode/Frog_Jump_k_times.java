package Leetcode;

import java.util.Arrays;

public class Frog_Jump_k_times {
    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int ans = frogJump(arr.length, arr, 3);
        System.out.println(ans);
    }

    public static int frogJump(int n, int height[], int k) {
        int[] dp=new int[n];
        dp[0]=0;

        for (int i = 1; i < n; i++) {
        int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i>=j){
                int jump = dp[i-j]+ Math.abs(height[i]- height[i-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }

        dp[i] = mmSteps;
        }
        return dp[n-1];
    }
}
