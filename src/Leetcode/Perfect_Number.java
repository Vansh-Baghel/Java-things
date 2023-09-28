package Leetcode;

public class Perfect_Number {
    static int isPerfectNumber(long N) {
        long sum = 1;
        if (N == 1) return 0;

        // We need to consider this from 2, because if we take i as 1, then we will end up adding the number is due to N/i.
        for (long i = 2; i*i < N; i++) {
            if (N%i == 0){
                sum += i;
                // Because if N=100, so we don't need to consider 10 twice.
                if (N/i != i) sum += N/i;
            }
        }
        return sum == N ? 1 : 0;
    }
}
