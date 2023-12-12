package Leetcode;

public class Sum_of_Digits_Prime_Non_Prime {
    public static void main(String[] args) {
        System.out.println(digitPrime(5602));
    }
    static int digitPrime(int N){
        int sum = 0;
        while (N > 10) {
            int temp = N;
            sum = 0;
            while (temp > 0) {
                int rem = temp % 10;
                sum += rem;
                temp /= 10;
            }
            N = sum;
        }

        if (N <= 1) return 0;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return 0;
        }

        return 1;
    }
}
