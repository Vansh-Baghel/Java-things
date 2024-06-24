package Leetcode;

import java.util.*;

public class Maximum_Score_After_Splitting_a_String {
    static int maxScore(String s) {
        // Brute
        int z = 0, o = 0, n = s.length(), maxi = 0;

        for (int i = 0; i < n - 1; i++) {
            z = 0;
            o = 0;

            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') z++;
            }
            for (int k = i+1; k < n; k++) {
                if (s.charAt(k) == '1') o++;
            }

            maxi = Math.max(maxi, o + z);
        }

        return maxi;
    }

    static int maxScore2(String s) {
//        Multiple left but better
        int z = 0, o = 0, n = s.length(), maxi = 0, totalOnes = 0;

        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1') totalOnes++;
        }

        for (int i = 0; i < n - 1; i++) {
            z = 0;
            o = 0;

            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') z++;
                else o++;
            }

            int rightOnes = totalOnes - o;
            maxi = Math.max(maxi, rightOnes + z);
        }

        return maxi;
    }

    static int maxScore3(String s) {
        // 1 pass
        int z = 0, o = 0, n = s.length(), maxi = 0, totalOnes = 0;

        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1') totalOnes++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') z++;
            else o++;

            // Total = ZeroOnLeft + OnesOnRight, TotalOnes = OnesOnLeft + OnesOnRight, therefore OnesOnRight = TotalOnes - OnesOnLeft,
            // Total = ZeroOnLeft + TotalOnes - OnesOnLeft == (ZeroOnLeft - OnesOnLeft) + TotalOnes
            int cnt = (z - o) + totalOnes;
            maxi = Math.max(maxi, cnt);
        }

        return maxi;
    }
}
