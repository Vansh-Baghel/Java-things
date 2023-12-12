package Leetcode;

public class Largest_Odd_Number_in_String {
    static String largestOddNumber(String num) {
        String res = "";
        int n = num.length();

        for (int i = n - 1; i >= 0; i--){
            if (num.charAt(i) % 2 != 0) {
                res = num.substring(0, i+1);
                break;
            }
        }

        return res;
    }
}
