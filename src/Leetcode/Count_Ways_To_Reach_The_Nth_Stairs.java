package Leetcode;

public class Count_Ways_To_Reach_The_Nth_Stairs {
    public static void main(String[] args) {
        int ans = countDistinctWayToClimbStair(3);
        System.out.println(ans);
    }

    // Both TLE
    public static int countDistinctWayToClimbStair(long nStairs) {
        if (nStairs == 1 || nStairs == 2) return (int)nStairs;

        int jump1 = countDistinctWayToClimbStair(nStairs - 1);
        int jump2 = countDistinctWayToClimbStair(nStairs - 2);

        return jump1 + jump2;
    }

    public static int countDistinctWayToClimbStair2(long nStairs) {
        if (nStairs == 1 || nStairs == 2) return (int)(nStairs);

        int a = 1, b = 2, c = 1;

        for (int i = 2; i < nStairs; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
