package Leetcode.Contest;

public class Divisible_and_Non_divisible_Sums_Difference {
    public int differenceOfSums(int n, int m) {
        int div=0,nonDiv=0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) div+=i;
            else nonDiv += i;
        }
        return nonDiv-div;
    }
}
