package Leetcode;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int ans = frogJump3(arr.length, arr);
        System.out.println(ans);
    }

    // With recursion: TLE
//    public static int frogJump(int n, int heights[]) {
//        return dpRecursion(n - 1, heights);
//    }
//
//    private static int dpRecursion(int n, int[] heights) {
//        if (n == 0) return 0;
//
//        int left = dpRecursion(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
////     Integer.MAX_VALUE because if it was 0, then Math.min 0 leleta, rather than left value. n > 1 condition because we are doing n-2
////
//        int right = Integer.MAX_VALUE;
//        if (n > 1) right = dpRecursion(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
//
//        return Math.min(left, right);
//    }


    // Using Memoization => Top to Down, means tree k top se will go down. SC: O(N) + O(N)
    public static int frogJump(int n, int heights[]) {
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return dpRecursion(n - 1, heights, dp);
    }

    private static int dpRecursion(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int left = dpRecursion(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = n > 1 ? dpRecursion(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]) : Integer.MAX_VALUE;

        return dp[n] = Math.min(left, right);
    }


    // Using Tabulation => Down to Top, means neche se chalu krke, tree k root tak will go. SC: O(N)
    public static int frogJump2(int n, int heights[]) {
        int dp[]=new int[n];
        dp[0]=0;

        for (int i = 1; i < n; i++) {
            int left = dp[i-1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;

            if (i > 1) right = dp[i-2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // Optimized. SC: O(1)
    public static int frogJump3(int n, int heights[]) {
        int a = 0, b=0,c=0;

        for (int i = 1; i < n; i++) {
            int first = a + Math.abs(heights[i] - heights[i - 1]);
            int second = Integer.MAX_VALUE;

            if (i > 1) second = b + Math.abs(heights[i] - heights[i - 2]);

            c = Math.min(first, second);
            b=a;
            a=c;
        }
        return a;
    }
}
