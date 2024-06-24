package Leetcode;

import java.util.HashSet;

public class Jump_Game_III {
    static boolean canReach(int[] arr, int start) {
        int n = arr.length, idx = start;
        boolean[] vis = new boolean[n];

        return isPossible(start, n, arr, vis);
    }

    private static boolean isPossible(int idx, int n, int[] arr, boolean[] vis) {
        if (idx < 0 || idx >= n || vis[idx]) return false;

        if (arr[idx] == 0) return true;

        vis[idx] = true;

        boolean front = isPossible(idx + arr[idx], n, arr, vis);
        boolean back = isPossible(idx - arr[idx], n, arr, vis);

        return front || back;
    }
}
