//https://leetcode.com/problems/reverse-integer/
package Leetcode;

public class Reverse_Number_Int_Range {
    public static void main(String[] args) {

    }

    static int reverse(int x) {
        int rev = 0;
        int rem = 0;

        while (x != 0){
            rem = x % 10;

//            In this step , we are checking that if the reversed value is exceeding the integer limit or not. In the step below it , we are trying to perform rev * 10 . So when rev is about to exceed , rev * 10 already would've exceed and therefore to avoid the runtime error due to out of range value , we are putting this condition here and dividing it by 10 . Its same as checking rev * 10 < Integer.MIN_VALUE but in that case the value will already exceed and will throw the error before checking the condition . If explanation is not understood , watch https://www.youtube.com/watch?v=0fwrMYPcGQ0 .
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            rev = rev * 10 + rem;
            x /= 10;
        }
        return rev;
    }
}
