package Leetcode;

import java.util.*;

public class Minimize_the_Maximum_Difference_of_Pairs {
    static int minimizeMax(int[] nums, int p) {
        int n = nums.length, s = 0, e = 0, ans = Integer.MAX_VALUE;

        Arrays.sort(nums);

        e = nums[n - 1] - nums[0];

        while (s <= e){
            int m = s + (e - s) / 2;

            if (findCount(m, nums) >= p){
                ans = m;
                e = m - 1;
            } else s = m + 1;
        }

        return ans;
    }

    private static int findCount(int m, int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int nxt = nums[i+1];

            if (nxt - cur <= m){
                cnt++;
                i++;
            }
        }

        return cnt;
    }
}
