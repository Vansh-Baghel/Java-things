package Leetcode;

public class Prime_String {
    public static void main(String[] args) {
        System.out.println(isPrimeString("geeksforgeeks"));
    }
    static boolean isPrimeString(String s) {
        int sum = 0;

        for (char ch: s.toCharArray()){
            sum += ch;
        }

        return isPrime(sum);
    }

    private static boolean isPrime(int sum) {
        if (sum <= 1) return true;

        for (int i = 2; i*i < sum; i++) {
            if (sum % i == 0) return false;
        }

        return true;
    }
}
