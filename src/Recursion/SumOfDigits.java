package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(2320));
    }

    static int sumOfDigits(int n) {
        if (n % 10 == n){
            return n;
        }

//        This equation will get the last digit and keep on adding it till there comes a point where n % 10 returns n ie 1 % 10 == 1. This recursive function will call n / 10 ka value , here for n = 123 , it'll call 12.
        return n % 10 + sumOfDigits(n / 10);
    }
}
