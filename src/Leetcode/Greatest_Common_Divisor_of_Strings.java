package Leetcode;

public class Greatest_Common_Divisor_of_Strings {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    static String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if (!(str1 + str2).equals(str2+str1)) return "";

        return str1.substring(0, gcd(n, m));
    }

    static private int gcd(int n, int m) {
        while (n % m != 0){
            int rem = n % m;
            n = m;
            m = rem;
        }
        return m;
    }
}
