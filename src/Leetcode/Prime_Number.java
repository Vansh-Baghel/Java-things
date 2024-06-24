package Leetcode;

public class Prime_Number {
    public static void main(String[] args) {
        System.out.println(isPrime(997));
    }

    static int isPrime(int N){
        if (N <= 1) return 0;
        // Comparing squares of each number. If number is 37 then numbers till 6 will have a chance to have it in the table. 7 will have its multiple smaller than 7 ie 7 * 7 = 49, so it will be anything between 1 to 6, which we already covered.
        for (int i = 2; i*i <= N; i++) {
            if (N % i == 0) return 0;
        }
        return 1;
    }
}
