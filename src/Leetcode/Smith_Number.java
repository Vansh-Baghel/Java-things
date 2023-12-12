package Leetcode;

public class Smith_Number {
    public static void main(String[] args) {
        System.out.println(smithNum(997));
    }

    static int smithNum(int n) {
        int sum = 0, numSum = 0, temp = n;

        numSum = sumOfEachNum(temp);

        // If sum of n hee prime hua, toh answer not possible because uska khudke alawa koi aur factor hoga hee nhi. Warna any prime number will return true because in the end it will be divisible to itself, ending up taking its factor (own) sum. then both sum and numSum will ofcourse be true since both are same numbers.
        if (isPrime(n)) return 0;

        sum = primeFactorSum(n);

        return sum == numSum ? 1 : 0;
    }

    private static int sumOfEachNum(int temp) {
        int sum = 0;

        while (temp > 0) {
            int rem = temp % 10;
            sum += rem;
            temp/=10;
        }

        return sum;
    }

    private static int primeFactorSum(int n) {
        int sum = 0, num = 2;

        while (n > 1){
            if (isPrime(num)){
                while (n % num == 0) {
                    // Because if the prime number is of more than 1 digit, then we need to take sum for each of them. Like 14 will become 5, and 197 will become 17, and so on.
                    sum += sumOfEachNum(num);
                    n /= num;
                }
            }
            num++;
        }

        return sum;
    }

    private static boolean isPrime(int N) {
        if (N <= 1) return false;

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return false;
        }

        return true;
    }
}
