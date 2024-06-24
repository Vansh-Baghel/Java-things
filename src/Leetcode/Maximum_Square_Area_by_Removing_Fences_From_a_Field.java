package Leetcode;

import java.util.*;

public class Maximum_Square_Area_by_Removing_Fences_From_a_Field {
    static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long res = 0, mod = 1000000007;
        HashSet<Integer> hs = new HashSet<>();
        int h = hFences.length, v = vFences.length;

        // Creating new arrays because we need to add the additional m and n into the fences.
        int[] hFen = Arrays.copyOf(hFences, h + 2);
        int[] vFen = Arrays.copyOf(vFences, v + 2);
        hFen[h] = 1; hFen[h + 1] = m;
        vFen[v] = 1; vFen[v + 1] = n;

        // Basic idea is that, we need to find a matrix which is forming square, ie, x and y coord ka distance same hona chahiye. Means brute force mai ye krlo ki store all the difference ka value from each horizontal element. Then do the same with vertical and check if the hashSet contains that value or not. If it does, toh answer update krdo.

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                hs.add(Math.abs(hFen[i] - hFen[j]));
            }
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                int vDif = Math.abs(vFen[i] - vFen[j]);
                if (hs.contains(vDif)){
                    // Matlab side milgya with same length
                    res = Math.max(res, vDif);
                }
            }
        }

        // returning the area
        return res == 0 ? - 1 : (int)((res * res) % mod);
    }
}
