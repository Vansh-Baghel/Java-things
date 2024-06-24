package Leetcode;

import java.util.Arrays;

public class Techfest_and_the_Queue {
    public static void main(String[] args) {
        System.out.println(sumOfPowers2(9, 14));
    }

    static long sumOfPowers(long a, long b) {
        long res = 0;

        for (long num = a; num <= b; num++) {
            res += curPowerSum(num);
        }

        return res;
    }

    static long curPowerSum(long num) {
        int div = 2, sum = 0;

        while (num != 1 && !isPrime(num)){
            while (num % div == 0) {
                sum++;
                num/=div;
            }
            div++;
        }

        // Because prime number khudse divide hoga in the end
        if (num != 1) sum++;

        return sum;
    }

    static boolean isPrime(long N){
        if (N <= 1) return false;
        // Comparing squares of each number. If number is 37 then numbers till 6 will have a change to have it in the table. 7 will have its multiple smaller than 7 ie 7 * 7 = 49, so it will be anything between 1 to 6, which we already covered.
        for (long i = 2; i*i <= N; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static long sumOfPowers2(long a, long b) {
        // code here
        int[] smallestPrimeFactor = new int[(int)b+1];
        Arrays.fill(smallestPrimeFactor, -1);

        for (int i = 2; i <= b; i++) {
            if (smallestPrimeFactor[i] == -1){
                for (int j = i; j <= b; j+=i) {
                    // If -1 hai toh hee fill kro, warna its already filled by other shorter value
                        smallestPrimeFactor[j] = i;
                }
            }
        }

        System.out.println(Arrays.toString(smallestPrimeFactor));

        int res = 0;

        for (int i = (int)a; i <= b; i++) {
            int temp = i;

            while (temp!=1) {
                temp /= smallestPrimeFactor[temp];
                res++;
            }
        }

        return res;
    }
}
