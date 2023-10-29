package Leetcode;

import java.util.*;

public class Divisible_Set {
    public static void main(String[] args) {
        int[] arr = {3,3,3};
        System.out.println(divisibleSet(arr));
    }

    public static List< Integer > divisibleSet(int []arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int[] dp = new int[n];
        int lastIdx = 0;
        int[] hash2 = new int[n];
        int maxi = 0;

        for (int idx = 1; idx < n; idx++) {
            hash2[idx]=idx;
            for (int prev = 0; prev < idx; prev++) {
                if (dp[idx] < 1 + dp[prev] && arr[idx] % arr[prev] == 0) {
                    dp[idx] = 1 + dp[prev];
                    hash2[idx] = prev;
                }
            }

            if (dp[idx] > maxi){
                maxi = dp[idx];
                lastIdx = idx;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIdx]);

        while (hash2[lastIdx] != lastIdx){
            lastIdx = hash2[lastIdx];
            ans.add(arr[lastIdx]);
        }

        Collections.reverse(ans);

        return ans;
    }
}
