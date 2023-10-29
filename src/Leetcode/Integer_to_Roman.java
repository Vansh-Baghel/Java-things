package Leetcode;

public class Integer_to_Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(18));
    }

    static String intToRoman(int num) {
        int[] intCode = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < intCode.length; i++) {
            while (num >= intCode[i]) {
                // This will give that how many times do we need to add that roman number.
                int product = num / intCode[i];

                // Add till its greater than 0.
                while (product > 0) {
                    ans.append(code[i]);
                    product--;
                }
                // Change the number with the remainder.
                num %= intCode[i];
            }
        }

        return ans.toString();
    }
}
