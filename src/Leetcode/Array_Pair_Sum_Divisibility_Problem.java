package Leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class Array_Pair_Sum_Divisibility_Problem {
    public static void main(String[] args) {
        int[] nums = {9, 5, 7, 3};
        int k = 6;
        System.out.println(canPair(nums, k));
    }

    static boolean canPair(int[] nums, int k) {
        int n = nums.length;
        boolean[] vis = new boolean[n];

        for (int i = n - 1; i > 0; i--) {
            if (!vis[i]) {
                vis[i] = true;
                if (!pairExists(i - 1, k, nums[i], nums, vis)) return false;
            }
        }

        return true;
    }

    static boolean pairExists(int idx, int k, int sum, int[] nums, boolean[] vis) {
        if (idx < 0) return false;
        if (!vis[idx] && (sum + nums[idx]) % k == 0) {
            vis[idx] = true;
            return true;
        }

        return pairExists(idx - 1, k, sum, nums, vis);
    }

    public boolean canPair2(int[] nums, int k) {
        // Code here
        int n = nums.length;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]){
                for (int j = i + 1; j < n; j++) {
                    if ((nums[i] + nums[j]) % k == 0) {
                        vis[i] = true;
                        vis[j] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }

        return true;
    }

    public boolean canPair3(int[] nums, int k) {
        HashSet<Integer> remainders = new HashSet<>();

        for (int num : nums) {
            int rem = num % k;
            if (remainders.contains((k - rem) % k)) {
                remainders.remove((k - rem) % k);
            } else {
                remainders.add(rem);
            }
        }
        return remainders.isEmpty();
    }
}
