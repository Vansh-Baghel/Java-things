//https://leetcode.com/problems/integer-to-roman/
package Leetcode;

public class Int_Roman {
    public static void main(String[] args) {

    }

    static String intToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder romanAns = new StringBuilder();
        for (int i = 0; i < values.length ; i++) {
            while (num >= values[i]){
                num -= values[i];
                romanAns.append(strs[i]);
            }
        }
//        Here toString is converting the stringbuilder into string because the return type is string.
        return romanAns.toString();
    }
}
