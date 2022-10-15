//https://leetcode.com/problems/plus-one/
package Leetcode;

public class Plus_One {
    public static void main(String[] args) {

    }

    static int[] plusOne(int[] digits) {
        int n = digits.length;
//        i will start from the end element of array .
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
                digits[i] = 0;
        }

        int[] num = new int[n + 1];
        num[0] = 1;
        return num;
    }
}
