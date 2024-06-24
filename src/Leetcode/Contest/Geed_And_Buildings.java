package Leetcode.Contest;

public class Geed_And_Buildings {
    public static long maximum_energy(int n, int[] heights) {
        long maxi = 0;

        for (int i = 0; i < n; i++){
            long prev = heights[i];
            long xor = heights[i];

            for (int j = i + 1; j < n; j++){
                long cur = heights[j];

                if(prev < cur) {
                    xor ^= cur;
                    prev=cur;
                }
            }
            maxi = Math.max(maxi, xor);
        }

        return maxi;
    }
}
