package Recursion;

public class ReverseTheNumber {
    public static void main(String[] args) {
        System.out.println(reverse(3421));
    }

        static int reverse(int n){
            if (n % 10 == n){
                return n;
        }
//            We use this formula to get the power value of any number.
            int digits = (int) Math.log10(n) + 1;
            int rem = n % 10;
//          Basically we are getting the last digit of the number and multiplying it with the 10 ^ ((digits of n) - 1) . By this we can add all the next numbers adjacent to the start one.
            return rem * (int) Math.pow(10 , digits - 1) + reverse(n/10);
    }
}
