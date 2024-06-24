package Leetcode;

import java.util.Arrays;

public class Assign_Cookies {
    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int idx1 = 0, idx2 = 0, n = g.length, m = s.length;

        while (idx1 < n && idx2 < m){
            if (g[idx1] <= s[idx2]) {
                idx1++;
            }
            idx2++;
        }

        return Math.min(idx2, idx1);
    }
}
