package Leetcode.Contest;

public class Power_of_2 {
    public static void main(String[] args) {
        System.out.println(isPowerofTwo(0));
    }
    public static boolean isPowerofTwo(long n){
        if (n == 0 || n >= 2 && n % 2 == 1) return false;
        if (n == 1) return true;

        return isPowerofTwo(n/2);
    }
}
