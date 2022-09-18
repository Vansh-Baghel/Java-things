package Recursion;

public class FibonacciUsingRecursion {
    public static void main(String[] args) {
        int result = fib(2);
        System.out.println(result);
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, c = 1;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}