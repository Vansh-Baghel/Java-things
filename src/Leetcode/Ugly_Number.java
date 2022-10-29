//https://leetcode.com/problems/ugly-number/
package Leetcode;

public class Ugly_Number {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }

    static boolean isUgly(int n) {
//        because the number is only positive number, neither 0 nor -ve can be used.
        if (n == 0) return false;

        int[] nums = {2,3,5};

        for(int i = 0 ; i < nums.length ; i++){
//            It will try and divide 2,3,5 all . And if the output is 1 , means we found the answer.
            while (n % nums[i] == 0){
                n /= nums[i];
            }
        }
            return n == 1;
    }
}
