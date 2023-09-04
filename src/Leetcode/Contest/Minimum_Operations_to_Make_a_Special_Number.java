//https://leetcode.com/problems/minimum-operations-to-make-a-special-number/description/
package Leetcode.Contest;

public class Minimum_Operations_to_Make_a_Special_Number {
    public static void main(String[] args) {
        int ans = minimumOperations("2908305");
        System.out.println(ans);
    }
    static int minimumOperations(String num) {
        boolean fivefound = false;
        boolean zerofound = false;
        for (int i =num.length()-1; i >=0;i--) {
            // It will check both the conditions at the same time and jo pehle close hua, that will be the answer.
            // num.length()-2 is done to not include the 0 or 5 number ka el and i wala element.
            if (zerofound && num.charAt(i)=='0') return num.length()-2-i;
            if (zerofound && num.charAt(i)=='5') return num.length()-2-i;
            if (fivefound && num.charAt(i)=='2') return num.length()-2-i;
            if (fivefound && num.charAt(i)=='7') return num.length()-2-i;
            if (num.charAt(i)=='5') fivefound = true;
            if (num.charAt(i)=='0') zerofound = true;
        }
        // If 30, 10, 40 aisa kuchh hua toh this condition, else remove all ie return length
        if (zerofound) return num.length()-1;
        return num.length();
    }
}
