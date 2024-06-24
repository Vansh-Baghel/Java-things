package Leetcode;

public class Consecutive_1s_not_allowed {
    public static void main(String[] args) {
        System.out.println(countStrings(6));
    }

    static long countStrings(int n) {
        long endingWithZero = 1, endingWithOne = 1, total = 2;

        while (n > 1){
            endingWithOne = endingWithZero;
            endingWithZero = total;
            total = endingWithZero + endingWithOne;
            n--;
        }

        return total;
    }
}
