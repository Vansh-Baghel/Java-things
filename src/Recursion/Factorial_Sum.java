package Recursion;

public class Factorial_Sum {
    public static void main(String[] args) {
        int factorial = fact(5);
        int addingRange = add(5);
        System.out.println(factorial);
        System.out.print(addingRange);
    }

    static int add(int n) {
        if (n <= 1){
            return 1;
        }
        return n + add(n - 1);
    }

    static int fact(int n){
//      factorial of 1 is 1 , therefore it must be the base condition from where all the factorials will be transferred.
        if (n <= 1){
            return 1;
        }

        return n * fact(n - 1);
    }
}
