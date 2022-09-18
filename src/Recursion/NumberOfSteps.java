package Recursion;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class NumberOfSteps {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

    static int numberOfSteps(int num) {
        int count = 0;

        while(num > 0) {
            if (num == 0) {
                return count;
            }
            if (num % 2 == 0) {
                count++;
                num /= 2;
            } else {
                count++;
                num -= 1;
            }
        }
        return count;
    }
}
