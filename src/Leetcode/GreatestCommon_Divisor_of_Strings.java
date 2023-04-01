//https://leetcode.com/problems/greatest-common-divisor-of-strings
package Leetcode;

public class GreatestCommon_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        if (str1 + str2 != str2 + str1) return "";
        int n3 = gcd(n1 , n2);
        return str1.substring(0, n3 + 1);
    }

    public static int gcd(int n1, int n2){
        while(n1%n2!=0){
            int rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }
}
