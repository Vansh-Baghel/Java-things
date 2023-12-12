package Leetcode;

public class Arranging_Coins {
    static int arrangeCoins(int n) {
        int idx = 1;

        while (n > 0){
            idx++;
            n-=idx;
        }

        return idx - 1;
    }

    static int arrangeCoins2(int n) {
        long s = 1, e = n;

        while (s <= e){
            long m = s + (e - s) / 2;

            if (sum(m) < n) s = m + 1;
            else if (sum(m) > n) e = m - 1;
            else return (int)m;
        }

        return (int)s - 1;
    }

    private static long sum(long m) {
        return (m * (m + 1)) / 2;
    }
}
