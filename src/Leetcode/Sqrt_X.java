package Leetcode;

public class Sqrt_X {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    static long mySqrt(int x) {
        long s = 0;
        long e = Integer.MAX_VALUE;
        long ans = 0;
        while (s <= e) {
            long m = s + (e - s) / 2;

            if (m * m <= x) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }
}