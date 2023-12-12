package Leetcode;

public class Minimum_distance_between_two_numbers {
    static int minDist(int a[], int n, int x, int y) {
        // code here
        int idx1=-1, idx2=-1, ans=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(a[i] == x) idx1 = i;
            else if (a[i] == y) idx2 = i;
            if(idx1 != -1 && idx2 != -1) ans = Math.min(ans, Math.abs(idx1 - idx2));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
