package Leetcode;

public class Transform_to_prime {
    static int minNumber(int arr[], int N){
        int sum = 0, res = 0;

        for (int num: arr) sum+=num;

        while (true){
            if (isPrime(sum)) break;
            res++;
            sum++;
        }

        return res;
    }

    private static boolean isPrime(int sum) {
        if (sum <= 1) return false;

        for (int i = 2; i*i <= sum; i++) {
            if (sum % i == 0) return false;
        }

        return true;
    }
}
