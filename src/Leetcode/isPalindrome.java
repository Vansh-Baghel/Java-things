//https://leetcode.com/problems/palindrome-number/
package Leetcode;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    static boolean isPalindrome(int x) {
        int rev= 0;
        int rem = 0;
        int unChangedX = x;

        while (x > 0){
            rem = x % 10;
            rev = rev * 10  + rem;
            x /= 10;
        }
        if (rev == unChangedX){
            return true;
        }
        else return false;
    }
}
