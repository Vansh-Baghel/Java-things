package Leetcode;

public class Minimize_the_Maximum_of_Two_Arrays {
    public static void main(String[] args) {
        System.out.println(minimizeSet(3,5,2,1));
    }
    static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long s = 1, e = (int)(2 * 1e9), possible = e + 1;
        long lcm = ((long) divisor1 * divisor2) / gcd(divisor1, divisor2);

        while (s <= e){
            long m = s + (e - s) / 2;
            long cnt1 = m - (m / divisor1);
            long cnt2 = m - (m / divisor2);
            long cntAll = m - (m / lcm);

            if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cntAll >= uniqueCnt1 + uniqueCnt2) {
                possible = Math.min(m, possible);
                e = m - 1;
            } else s = m + 1;
        }

        return (int)(possible);
    }

    private static int gcd(int divisor1, int divisor2) {
        if (divisor2 == 0) return divisor1;

        return gcd(divisor2, divisor1 % divisor2);
    }
}
